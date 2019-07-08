package com.winter.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winter.common.HttpsRequest;
import com.winter.common.UuidUtil;
import com.winter.model.manage.dimTourBas3dResource.DimTourBas3dResource;
import com.winter.model.manage.dimTourDevcSensor.DimTourDevcSensor;
import com.winter.model.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfo;
import com.winter.model.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistory;
import com.winter.service.manage.dimTourBas3dResource.DimTourBas3dResourceService;
import com.winter.service.manage.dimTourBasArea.DimTourBasAreaService;
import com.winter.service.manage.dimTourDevcSensor.DimTourDevcSensorService;
import com.winter.service.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfoService;
import com.winter.service.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class DimTourDevcSensorCompoent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DimTourDevcSensorService dimTourDevcSensorService;

    @Autowired
    private DimTourBasAreaService dimTourBasAreaService;

    @Autowired
    private DimTourBas3dResourceService dimTourBas3dResourceService;

    @Autowired
    private DwdParkOptDevcEventInfoService dwdParkOptDevcEventInfoService;

    @Autowired
    private DwdParkOptDevcEventInfoHistoryService dwdParkOptDevcEventInfoHistoryService;
    //监控点位

    private static final String IP = "https://api.dtuip.com";
//    private static final String IP = "https://120.76.31.182";
    /*登陆*/
    private static final String LOGIN = "/qy/user/login.html";
    /*设备列表*/
    private static final String LIST = "/qy/device/queryDevMoniData.html";
    /*报警列表*/
    private static final String QUERY_ALARMS_HISTORY = "/qy/alarms/queryAlarmsHistory.html";

    private static final String USER_NAME = "userName";
    private static final String USER = "13715257595";
    private static final String PWD_NAME = "password";
    private static final String PWD = "hb123456";

//    @Scheduled(fixedRate=10000)
    public void requestList(){
        JSONObject resJson = login();
        if(resJson!=null){
            String url = IP + LIST;
            String param = "{" +
                "\"userApiKey\":\"" +resJson.getString("userApikey")+"\","+
                "\"flagCode\":\"" +resJson.getString("flagCode")+"\","+
            "}";
            String res = HttpsRequest.httpsRequest(url,"POST",param);
            if(res!=null&&!res.equals("")){
                System.out.println(res);
                resJson = JSON.parseObject(res);
                if(resJson.getString("flag").equals("00")){
                    JSONArray devList = resJson.getJSONArray("deviceList");
                    if(devList!=null&&!devList.isEmpty()){
                        JSONObject devItem = null;
                        for(int i=0;i<devList.size();i++){
                            devItem = devList.getJSONObject(i);
                            JSONArray sensorList = devItem.getJSONArray("sensorList");//获取设备下传感器列表
                            if(sensorList!=null&&!sensorList.isEmpty()){
                                updateList(devItem,sensorList);
                            }else{
                                System.out.println(">>>>>>>>>>>>>>>传感器列表为空>>>>>>>>>>>>>>>");
                            }
                        }
                    }else{
                        System.out.println(">>>>>>>>>>>>>>>设备列表为空>>>>>>>>>>>>>>>");
                    }
                }else{
                    System.out.println(">>>>>>>>>>>>>>>获取列表失败>>>>>>>>>>>>>>>"+resJson.getString("msg"));
                }
            }
        }
    }
    private JSONObject login(){
        String url = IP + LOGIN;
        String param = "{" +
                "\""+USER_NAME+"\":\"" +USER+"\","+
                "\""+PWD_NAME+"\":\"" +PWD+"\""+
            "}";
        String res = HttpsRequest.httpsRequest("https://api.dtuip.com/qy/user/login.html","POST",param);
        JSONObject resJson = null;
        if(res!=null&&!res.equals("")){
            System.out.println(res);
            resJson = JSON.parseObject(res);
            if(!resJson.getString("flag").equals("00")){
                System.out.println(">>>>>>>>>>>>>>>登录失败>>>>>>>>>>>>>>>"+resJson.getString("msg"));
                resJson = null;
            }else{
                System.out.println(">>>>>>>>>>>>>>>登录成功>>>>>>>>>>>>>>>"+resJson.getString("msg"));
                System.out.println(">>>>>>>>>>>>>>>userApikey:"+resJson.getString("userApikey"));
                System.out.println(">>>>>>>>>>>>>>>flagCode:"+resJson.getString("flagCode"));
            }
        }else{
            System.out.println(">>>>>>>>>>>>>>>登录失败");
        }
        return resJson;
    }
    private void updateList(JSONObject decItem,JSONArray sensorList){

        String deviceId = decItem.getString("deviceId");//设备ID
        String deviceNo = decItem.getString("deviceNo");//设备序列号
        String deviceName = decItem.getString("deviceName");//设备名称
        String deviceLng = decItem.getString("deviceLng");//设备纬度
        String deviceLat = decItem.getString("deviceLat");//设备经度
        String faultDelay = decItem.getString("faultDelay");//掉线延迟时间
        String deviceIoc = decItem.getString("deviceIoc");//设备图标
        String defaultTimescale = decItem.getString("defaultTimescale");//记录间隔时间
        String createDateTime = decItem.getString("createDateTime");//创建时间在他们平台
        JSONObject sensorItem ;
        String sensorId = "";//传感器id
        String sensorName = "";//传感器名称
        String sensorType = "";//传感器类型（1数值型;2开关型(可操作);3定位型;5开关型(不可操作);6挡位型）;7视频型;8字符串
        String iocUrl = "";//传感器图标地址
        int isLine = 0;//是否在线 status
        String lat = "";//传感器经度
        String lng = "";//传感器纬度
        String switcher = "";//挡位
        String value = "";//最新数值
        String updateDateTime = "";//最后更新时间
        Date now = new Date();

        DimTourDevcSensor dimTourDevcSensor = new DimTourDevcSensor();
        List<DimTourDevcSensor> os = new ArrayList<DimTourDevcSensor>();
        DimTourDevcSensor o = new DimTourDevcSensor();
        os = dimTourDevcSensorService.find(o);

        dimTourDevcSensor.setDeviceId(deviceId);
        dimTourDevcSensor.setDeviceNo(deviceNo);
        dimTourDevcSensor.setDeviceName(deviceName);
        dimTourDevcSensor.setDeviceLng(deviceLng);
        dimTourDevcSensor.setDeviceLat(deviceLat);
        dimTourDevcSensor.setFaultDelay(faultDelay);
        dimTourDevcSensor.setDeviceIco(deviceIoc);
        dimTourDevcSensor.setDefaultTimescale(defaultTimescale);
        dimTourDevcSensor.setCreateDateTime(createDateTime);
        dimTourDevcSensor.setUpdateTime(now);
        if(os!=null&&!os.isEmpty()){
            for(int i=0;i<sensorList.size();i++){
                sensorItem = sensorList.getJSONObject(i);
                sensorId = sensorItem.getString("sensorId");//传感器id
                sensorName = sensorItem.getString("sensorName");//传感器名称
                sensorType = sensorItem.getString("sensorType");//传感器类型（1数值型;2开关型(可操作);3定位型;5开关型(不可操作);6挡位型）;7视频型;8字符串
                iocUrl = sensorItem.getString("iocUrl");//传感器图标地址
                isLine = sensorItem.getInteger("isLine");//是否在线 status
                lat = sensorItem.getString("lat");//传感器经度
                lng = sensorItem.getString("lng");//传感器纬度
                switcher = sensorItem.getString("switcher");//挡位
                value = sensorItem.getString("value");//最新数值
                updateDateTime = sensorItem.getString("updateDateTime");//最后更新时间
                DimTourDevcSensor has_o = null;
                for(DimTourDevcSensor item:os){
                   if(item.getSensorId().equals(sensorId)){
                       System.out.println("数据库已有记录>>>>>>>>>>>>更新传感器设备信息:"+item.getSensorName());
                       has_o = item;
                       break;
                   }
                }
                if(has_o != null){//数据库中已存在传感器
                    has_o.setDeviceId(deviceId);
                    has_o.setDeviceNo(deviceNo);
                    has_o.setDeviceName(deviceName);
                    has_o.setDeviceLng(deviceLng);
                    has_o.setDeviceLat(deviceLat);
                    has_o.setFaultDelay(faultDelay);
                    has_o.setDeviceIco(deviceIoc);
                    has_o.setDefaultTimescale(defaultTimescale);
                    has_o.setCreateDateTime(createDateTime);
                    has_o.setUpdateTime(now);

                    has_o.setSensorId(sensorId);
                    has_o.setSensorName(sensorName);
                    has_o.setSensorType(sensorType);

                    has_o.setIocUrl(iocUrl);
                    has_o.setStatus(isLine);
                    has_o.setLat(lat);
                    has_o.setLng(lng);
                    has_o.setSwitcher(switcher);
                    has_o.setValue(value);
                    has_o.setUpdateDateTime(updateDateTime);
                    dimTourDevcSensorService.update(dimTourDevcSensor);

                    if(has_o.getStatus()!=isLine){
                        if(has_o.getResourceId()!=null&&!has_o.getResourceId().equals("")){//查找到点位
                            DimTourBas3dResource dimTourBas3dResource = new DimTourBas3dResource();
                            dimTourBas3dResource.setId(o.getResourceId());
                            List<DimTourBas3dResource> dimTourBas3dResources = dimTourBas3dResourceService.find(dimTourBas3dResource);
                            if(dimTourBas3dResources!=null&&!dimTourBas3dResources.isEmpty()){
                                dimTourBas3dResource = dimTourBas3dResources.get(0);
                                System.out.println(">>>>>>>>>>>>设备已有点位>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                                //设备离线则形成一个离线/故障事件存储到运行事件
                                DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
                                dwdParkOptDevcEventInfo.setRelevanceId(dimTourBas3dResource.getId());//3维 点位报警 所以存储的是关联id字段存的是点位ID
                                dwdParkOptDevcEventInfo.setType("3");//景观灯 3维点位事件
                                dwdParkOptDevcEventInfo.setWarning("0");//0离线 2报警 3火灾 4周界告警
                                List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
                                if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
                                    System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                                    dwdParkOptDevcEventInfo = dwdParkOptDevcEventInfos.get(0);
                                    if(isLine==1){//恢复正常 所以将事件闭环 将事件加到完成事件中
                                        System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>在info中删除该事件");
                                        dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
                                        insertEventOver(dwdParkOptDevcEventInfo);
                                    }
                                }else{
                                    System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                                    if(isLine!=1){
                                        String name = dimTourBas3dResource.getName()+"离线";
                                        String address = dimTourBas3dResource.getAddress();
                                        String warining = ""+isLine;//离线
                                        String content = dimTourBas3dResource.getAddress()+"-"+dimTourBas3dResource.getName()+":离线";
                                        insertEvent(dwdParkOptDevcEventInfo,name,address,warining,content,"2","0");
                                    }
                                }
                            }else{
                                System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
                            }
                        }else{
                            System.out.println(">>>>>>>>>>>>设备暂无点位");
                        }
                    }
                }else{//数据库不存在传感器 添加
                    System.out.println("数据库没有记录>>>>>>>>>>>>添加新的传感器设备信息:"+o.getSensorName());
                    insert(sensorId,sensorName,sensorType,iocUrl,isLine,lat,lng,switcher,value,updateDateTime);
                }
            }
        }else{//insert
            for(int i=0;i<sensorList.size();i++){
                sensorItem = sensorList.getJSONObject(i);
                sensorId = sensorItem.getString("sensorId");//传感器id
                sensorName = sensorItem.getString("sensorName");//传感器名称
                sensorType = sensorItem.getString("sensorType");//传感器类型（1数值型;2开关型(可操作);3定位型;5开关型(不可操作);6挡位型）;7视频型;8字符串
                iocUrl = sensorItem.getString("iocUrl");//传感器图标地址
                isLine = sensorItem.getInteger("isLine");//是否在线 status
                lat = sensorItem.getString("lat");//传感器经度
                lng = sensorItem.getString("lng");//传感器纬度
                switcher = sensorItem.getString("switcher");//挡位
                value = sensorItem.getString("value");//最新数值
                updateDateTime = sensorItem.getString("updateDateTime");//最后更新时间
                insert(sensorId,sensorName,sensorType,iocUrl,isLine,lat,lng,switcher,value,updateDateTime);
            }
        }
    }
    private void insert(String sensorId,String sensorName,String sensorType,String iocUrl,Integer isLine,String lat,String lng,String switcher,String value,String updateDateTime){
        DimTourDevcSensor o = new DimTourDevcSensor();
        o.setId(UuidUtil.get32UUID());
        o.setSensorId(sensorId);
        o.setSensorName(sensorName);
        o.setSensorType(sensorType);
        o.setIocUrl(iocUrl);
        o.setStatus(isLine);
        o.setLat(lat);
        o.setLng(lng);
        o.setSwitcher(switcher);
        o.setValue(value);
        o.setUpdateDateTime(updateDateTime);
        o.setCreateTime(new Date());
        dimTourDevcSensorService.insert(o);
    }
    private void insertEvent(DwdParkOptDevcEventInfo o,String name,String info,String waring,String content,String level,String status){
        Date now = new Date();
        o.setName(name);
        o.setInfo(info);//地址
        o.setWarning(waring);
        o.setContent(content);
        o.setLevel(level);//一般
        o.setStatus(status);//未处理
        o.setCreateTime(new Date());
        o.setHappenTime(new Date());
        o.setId(UuidUtil.get32UUID());
        dwdParkOptDevcEventInfoService.insert(o);
    }
    private void insertEventOver(DwdParkOptDevcEventInfo o){
        DwdParkOptDevcEventInfoHistory dwdParkOptDevcEventInfoHistory = new DwdParkOptDevcEventInfoHistory();
        dwdParkOptDevcEventInfoHistory.setId(o.getId());
        dwdParkOptDevcEventInfoHistory.setName(o.getName());
        dwdParkOptDevcEventInfoHistory.setInfo(o.getInfo());
        dwdParkOptDevcEventInfoHistory.setWarning(o.getWarning());
        dwdParkOptDevcEventInfoHistory.setType(o.getType());
        dwdParkOptDevcEventInfoHistory.setLevel(o.getLevel());
        dwdParkOptDevcEventInfoHistory.setStatus(o.getStatus());
        dwdParkOptDevcEventInfoHistory.setRelevanceId(o.getRelevanceId());
        dwdParkOptDevcEventInfoHistory.setCreateTime(o.getCreateTime());
        dwdParkOptDevcEventInfoHistory.setHappenTime(o.getHappenTime());
        dwdParkOptDevcEventInfoHistory.setResolveTime(o.getResolveTime());
        dwdParkOptDevcEventInfoHistory.setSolutionTime(new Date());

        System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>将事件加入到历史表中");
        dwdParkOptDevcEventInfoHistoryService.insert(dwdParkOptDevcEventInfoHistory);//加入到历史记录表中
    }
    private Date lastRequestQueryAlarmsHistory_time = new Date();
//    @Scheduled(fixedRate=5000)
    /***查询所有报警事件***/
    private void requestQueryAlarmsHistory(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        lastRequestQueryAlarmsHistory_time = new Date();
        System.out.println(formatter.format(lastRequestQueryAlarmsHistory_time));
        JSONObject resJson = login();
        //时间需要发起请求的间隔时间向前追溯这个间隔时间
        if(resJson!=null){
            String url = IP + QUERY_ALARMS_HISTORY;
            String param = "{" +
                    "\"page\":0,"+
                    "\"userApiKey\":\"" +resJson.getString("userApikey")+"\","+
                    "\"flagCode\":\"" +resJson.getString("flagCode")+"\","+
                    "}";
            String res = HttpsRequest.httpsRequest(url,"POST",param);
            if(res!=null&&!res.equals("")){
                System.out.println(res);
                resJson = JSON.parseObject(res);
                if(resJson.getString("flag").equals("00")){
                    JSONArray list = resJson.getJSONArray("result");
                    if(list!=null&&!list.isEmpty()){

                    }else{
                        System.out.println(">>>>>>>>>>>>>>>报警列表为空>>>>>>>>>>>>>>>");
                    }
                }else{
                    System.out.println(">>>>>>>>>>>>>>>报警列表失败>>>>>>>>>>>>>>>"+resJson.getString("msg"));
                }
            }
        }
    }
    //解析并提取最近发生的告警数据
    private void parsingQueryAlarmsHistory(JSONArray list,Date lastRequset){
        String id = "";//记录id
        String userId = "";//用户id
        String deviceId = "";//设备id
        String deviceName = "";//设备名称
        String sensorId = "";//传感器id
        String sensorName = "";//传感器名称
        String alarmsId = "";//报警id
        String triggerVal = "";//报警值
        String triggerEmail = "";//报警接收邮箱
        String triggerMobile = "";//报警接收收集
        String triggerWeChat = "";//报警接收微信
        String triggerContent = "";//报警内容
        String triggerDate = "";//报警时间
        String status = "";//发送状态（0、发送成功，1、发送失败）
        String message = "";//失败消息

        DimTourDevcSensor dimTourDevcSensor = new DimTourDevcSensor();
        List<DimTourDevcSensor> os = new ArrayList<DimTourDevcSensor>();
        DimTourDevcSensor o = new DimTourDevcSensor();
        os = dimTourDevcSensorService.find(o);

        for(int i=0;i<list.size();i++){
            JSONObject jsonObj = list.getJSONObject(i);
            id = jsonObj.getString("id");
            userId = jsonObj.getString("userId");
            deviceId = jsonObj.getString("deviceId");
            deviceName = jsonObj.getString("deviceName");
            sensorId = jsonObj.getString("sensorId");
            sensorName = jsonObj.getString("sensorName");
            alarmsId = jsonObj.getString("alarmsId");
            triggerVal = jsonObj.getString("triggerVal");
            triggerEmail = jsonObj.getString("triggerEmail");
            triggerMobile = jsonObj.getString("triggerMobile");
            triggerWeChat = jsonObj.getString("triggerWeChat");
            triggerContent = jsonObj.getString("triggerContent");
            triggerDate = jsonObj.getString("triggerDate");
            status = jsonObj.getString("status");
            message = jsonObj.getString("message");
            DimTourDevcSensor has_o = null;
            for(DimTourDevcSensor item:os){
                if(item.getSensorId().equals(sensorId)){
                    has_o = item;
                    break;
                }
            }
            if(has_o!=null){
                System.out.println("数据库已有记录>>>>>>>>>>>>获取到传感器:"+has_o.getSensorName());
                if(has_o.getResourceId()!=null&&!has_o.getResourceId().equals("")){//查找到点位
                    DimTourBas3dResource dimTourBas3dResource = new DimTourBas3dResource();
                    dimTourBas3dResource.setId(o.getResourceId());
                    List<DimTourBas3dResource> dimTourBas3dResources = dimTourBas3dResourceService.find(dimTourBas3dResource);
                    if(dimTourBas3dResources!=null&&!dimTourBas3dResources.isEmpty()){
                        dimTourBas3dResource = dimTourBas3dResources.get(0);
                        System.out.println(">>>>>>>>>>>>设备已有点位>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                        //设备离线则形成一个离线/故障事件存储到运行事件
                        DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
                        dwdParkOptDevcEventInfo.setRelevanceId(dimTourBas3dResource.getId());//3维 点位报警 所以存储的是关联id字段存的是点位ID
                        dwdParkOptDevcEventInfo.setType("3");//3维点位事件
                        dwdParkOptDevcEventInfo.setWarning("2");//0离线 2报警 3火灾 4周界告警
                        List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
                        if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
                            System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                            dwdParkOptDevcEventInfo = dwdParkOptDevcEventInfos.get(0);
                            System.out.println(">>>>>>>>>>>>在info中删除该事件");
                            dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
                            insertEventOver(dwdParkOptDevcEventInfo);

                        }else{
                            System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                        }
                        String name = dimTourBas3dResource.getName()+"水浸报警";
                        String address = dimTourBas3dResource.getAddress();
                        String warining = "2";//0离线 2报警 3火灾 4周界告警
//                            String content = dimTourBas3dResource.getAddress()+"-"+dimTourBas3dResource.getName()+":报警";
                        String content = dimTourBas3dResource.getAddress()+"-"+triggerContent;
                        insertEvent(dwdParkOptDevcEventInfo,name,address,warining,content,"2","0");
                    }else{
                        System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
                    }
                }else{
                    System.out.println(">>>>>>>>>>>>设备暂无点位");
                }
            }else{
                System.out.println("数据库未有记录>>>>>>>>>>>>未能获取到传感器:");
            }

        }
    }
}
