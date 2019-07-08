package com.winter.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.winter.common.Ping;
import com.winter.common.UuidUtil;
import com.winter.model.manage.dimTourBas3dResource.DimTourBas3dResource;
import com.winter.model.manage.dimTourBasResource.DimTourBasResource;
import com.winter.model.manage.dimTourDevcVideoSurveillance.DimTourDevcVideoSurveillance;
import com.winter.model.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfo;
import com.winter.model.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistory;
import com.winter.service.manage.dimTourDevcVideoSurveillance.DimTourDevcVideoSurveillanceService;
import com.winter.service.manage.dimTourBas3dResource.DimTourBas3dResourceService;
import com.winter.service.manage.dimTourBasArea.DimTourBasAreaService;
import com.winter.service.manage.dimTourBasResource.DimTourBasResourceService;
import com.winter.service.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfoService;
import com.winter.service.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class DimTourDevcVideoSurveillanceCompoent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private  DimTourDevcVideoSurveillanceService dimTourDevcVideoSurveillanceService;

    @Autowired
    private DimTourBasAreaService dimTourBasAreaService;

    @Autowired
    private DimTourBasResourceService dimTourBasResourceService;

    @Autowired
    private DimTourBas3dResourceService dimTourBas3dResourceService;

    @Autowired
    private DwdParkOptDevcEventInfoService dwdParkOptDevcEventInfoService;

    @Autowired
    private DwdParkOptDevcEventInfoHistoryService dwdParkOptDevcEventInfoHistoryService;

    private static final String IP_TRPE = "http://";
    private static final String ARTEMIS_PATH  = "/artemis";

    private static final String GET_CAMERAS = "/api/resource/v1/cameras";//此接口用来获取所有视频数据。

//    private static final String PREVIEWURLS = "/api/video/v1/cameras/previewURLs";
    //照明设备
//    @Scheduled(fixedRate=5000)
    public void requestList(){
        ArtemisConfig.host = "192.168.0.40:80";
        ArtemisConfig.appKey = "25537814";
        ArtemisConfig.appSecret  = "YbemWmvIV3kFyYRuzwWY";
        String getRootApi = ARTEMIS_PATH + GET_CAMERAS;
//        String getRootApi = ARTEMIS_PATH + PREVIEWURLS;
        Map<String, String> path = new HashMap<String, String>(2);
        path.put(IP_TRPE,getRootApi);
        String contentType = "application/json";
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo", 1);   //此参数非必填
        jsonBody.put("pageSize", 1000);   //此参数非必填

//        jsonBody.put("cameraIndexCode", "f29c220b3cf545b5bd646eb211a4c753");
//        jsonBody.put("streamType", 0);
//        jsonBody.put("protocol", "rtsp");
//        jsonBody.put("transmode", 1);
//        jsonBody.put("expand", "streamform=ps");

        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType);
        System.out.println("请求路径："+ getRootApi + ",请求参数："+ body + ",返回结果：" + result);
        JSONObject resJson = null;
        if(result!=null&&!result.equals("")){
            resJson = JSON.parseObject(result);
        }
        if(resJson!=null){
//            code	String	返回码	是	0-查询成功 其他-参见错误码
//            msg	String	返回描述	是	记录接口执行情况说明信息
//            data	Object	返回数据	否	分页信息
//                    +total	Number	查询数据总量	是	总数据量
//            +pageNo	Number	当前页数	是	页数
//            +pageSize	Number	单页呈现数量	是	每页大小
//            +list	CameraInfo[]	监控点列表	否	参见附录C.6.2 CameraInfo属性说明
            int code = resJson.getInteger("code");
            if(code==0){
                resJson = resJson.getJSONObject("data");
                System.out.println("获取列表成功>>>>>>>>>>>>");
                if(resJson!=null){
                    int total = resJson.getInteger("total");
                    int pageNo = resJson.getInteger("pageNo");
                    int pageSize = resJson.getInteger("pageSize");
                    JSONArray list = resJson.getJSONArray("list");
                    System.out.println("获取解析成功>>>>>>>>>>>>total:"+total+"pageNo:"+pageNo+"pageSize:"+pageSize);
                    if(list!=null&&!list.isEmpty()){
                        updateList(list);
                    }else{
                        System.out.println("获取解析成功>>>>>>>>>>>>列表为空");
                    }

                }else{
                    System.out.println("获取解析失败>>>>>>>>>>>>");
                }
            }else{
                System.out.println(resJson.getString("msg"));
            }
        }
    }
    private void updateList(JSONArray list){
        DimTourDevcVideoSurveillance o = new DimTourDevcVideoSurveillance();
        JSONObject l;
        for(int i=0;i<list.size();i++){
            l = list.getJSONObject(i);
            String altitude = l.getString("altitude");//"altitude": null,//海拔
            String cameraIndexCode = l.getString("cameraIndexCode");//"cameraIndexCode": "eddf8458f74d42e9bf4ecfc752dba146",//监控点唯一标识
            String cameraName = l.getString("cameraName");//"cameraName": "3层吉米后厨入口",//监控点名称
            String cameraType = l.getString("cameraType");//"cameraType": 0,//监控点类型
            String cameraTypeName = l.getString("cameraTypeName");//"cameraTypeName": "枪机",//监控点类型说明
            String capabilitySet = l.getString("capabilitySet");//"capabilitySet": "io,event_io,event_ias,event_rule,event_heat,record,net,event_face,vss,ptz,status,maintenance,event_device",//能力集（详见数据字典，typeCode为xresmgr.capability_set）
            String capabilitySetName = l.getString("capabilitySetName");//"capabilitySetName": null,//能力集说明
            String intelligentSet = l.getString("intelligentSet");//"intelligentSet": null,//智能分析能力集（详见数据字典，typeCode为xresmgr.intelligent_set）
            String intelligentSetName = l.getString("intelligentSetName");//"intelligentSetName": null,//智能分析能力集说明
            String channelNo = l.getString("channelNo");//"channelNo": "33",//通道编号
            String channelType = l.getString("channelType");//"channelType": "digital",//通道类型
            String channelTypeName = l.getString("channelTypeName");//"channelTypeName": "数字通道",//通道子类型说明
            String createTime = l.getString("createTime");//"createTime": "2018-09-15T11:14:27.812+08:00",//创建时间
            String encodeDevIndexCode = l.getString("encodeDevIndexCode");//"encodeDevIndexCode": "1d3d5c26e6174cf1aa452f57cac91879",//所属编码设备唯一标识
            String encodeDevResourceType = l.getString("encodeDevResourceType");//"encodeDevResourceType": null,//所属设备类型（详见数据字典，typeCode为xresmgr.resource_type）
            String encodeDevResourceTypeName = l.getString("encodeDevResourceTypeName");//"encodeDevResourceTypeName": null,//所属设备类型说明
            String gbIndexCode = l.getString("gbIndexCode");//"gbIndexCode": null,//监控点国标编号
            String installLocation = l.getString("installLocation");//"installLocation": null,//安装位置
            String keyBoardCode = l.getString("keyBoardCode");//"keyBoardCode": null,//键盘控制码
            String latitude = l.getString("latitude");//"latitude": null,//纬度
            String longitude = l.getString("longitude");//"longitude": null,//经度
            String pixel = l.getString("pixel");//"pixel": null,//摄像机像素（1-普通像素，2-130万高清，3-200万高清，4-300万高清，取值参考数据字典，typeCode为xresmgr.piexl）
            String ptz = l.getString("ptz");//"ptz": null//云镜类型（1-全方位云台（带转动和变焦），2-只有变焦,不带转动，3-只有转动，不带变焦，4-无云台，无变焦，取值参考数据字典，typeCode为xresmgr.ptz_type）,
            String ptzName = l.getString("ptzName");//"ptzName": null,//云镜类型说明
            String ptzController = l.getString("ptzController");//"ptzController": null,// 云台控制(1-DVR，2-模拟矩阵，3-MU4000，4-NC600，取值参考数据字典，typeCode为xresmgr.ptz_control_type)
            String ptzControllerName = l.getString("ptzControllerName");//"ptzControllerName": null,//云台控制说明
            String recordLocation = l.getString("recordLocation");//"recordLocation": null,//录像存储位置（0-中心存储，1-设备存储，取值参考数据字典，typeCode为xresmgr.record_location）
            String recordLocationName = l.getString("recordLocationName");//"recordLocationName": null,//录像存储位置说明
            String regionIndexCode = l.getString("regionIndexCode");//"regionIndexCode": "2feadc43-ffef-464b-a2e2-b146a02de5ba",//所属区域唯一标识
            int status = l.getInteger("status")!=null?l.getInteger("status"):0;//"status": null,// 在线状态（0-不在线，1-在线，取值参考数据字典，typeCode为xresmgr.status）
            status = 1;
            String statusName = l.getString("statusName");//"statusName": null,//状态说明
            String transType = l.getString("transType");//"transType": 1,//传输协议（0-UDP，1-TCP，取值参考数据字典，typeCode为xresmgr.transType）
            String transTypeName = l.getString("transTypeName");//"transTypeName": "TCP",//传输协议类型说明
            String treatyType = l.getString("treatyType"); //"treatyType": null,//接入协议（详见数据字典，typeCode为xresmgr.protocol_type）
            String treatyTypeName = l.getString("treatyTypeName");//"treatyTypeName": null,//接入协议类型说明
            String viewshed = l.getString("viewshed");//"viewshed": null,// 可视域相关（JSON格式）
            String updateTime = l.getString("updateTime");//"updateTime": "2018-09-15T11:19:48.973+08:00"//更新时间 采用ISO8601标准，如2018-07-26T21:30:08+08:00 表示北京时间2017年7月26日21时30分08秒
            o.setId(cameraIndexCode);
            List<DimTourDevcVideoSurveillance> dimTourDevcVideoSurveillances = dimTourDevcVideoSurveillanceService.find(o);
            if(dimTourDevcVideoSurveillances!=null&&!dimTourDevcVideoSurveillances.isEmpty()){
                o = dimTourDevcVideoSurveillances.get(0);
                insertOrUpdateDevc(1,o,cameraName,regionIndexCode,channelNo,status,cameraType);
                if(o.getResourceId()!=null&&!o.getResourceId().equals("")){//查找到2d点位
                    DimTourBasResource dimTourBasResource = new DimTourBasResource();
                    dimTourBasResource.setId(o.getResourceId());
                    List<DimTourBasResource> dimTourBasResources = dimTourBasResourceService.find(dimTourBasResource);
                    if(dimTourBasResources!=null&&!dimTourBasResources.isEmpty()){
                        dimTourBasResource = dimTourBasResources.get(0);
                        System.out.println(">>>>>>>>>>>>设备已有2d点位>>>>>>>>>>>>获取设备2d点位信息:"+dimTourBasResource.getName());//设备离线则形成一个离线/故障事件存储到运行事件
                        DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
                        dwdParkOptDevcEventInfo.setRelevanceId(dimTourBasResource.getId());//2维 区域报警 所以存储的是关联id字段存的是二维点位id
                        dwdParkOptDevcEventInfo.setType("2");//2视频 2维点位事件
                        dwdParkOptDevcEventInfo.setWarning("0");//0离线 2报警 3火灾 4周界告警   因为周界告警与离线告警若是同一个设备的话需要检索对应的时间进行闭环
                        List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
                        if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
                            System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备2d点位信息:"+dimTourBasResource.getName());
                            dwdParkOptDevcEventInfo = dwdParkOptDevcEventInfos.get(0);
                            if(status==1){//恢复正常 所以将事件闭环 将事件加到完成事件中
                                System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>在info中删除该事件");
                                dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
                                insertEventOver(dwdParkOptDevcEventInfo);
                            }
                        }else{
                            System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备2d点位信息:"+dimTourBasResource.getName());
                            if(status!=1){
                                String name = dimTourBasResource.getName()+"离线";
                                String address = dimTourBasResource.getAddress();
                                String warining = ""+status;
                                String content = dimTourBasResource.getAddress()+"-"+dimTourBasResource.getName()+":离线";
                                insertEvent(dwdParkOptDevcEventInfo,name,address,warining,content,"2","0");
                            }
                        }
                    }else{
                        System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
                    }
                }else if(o.getResourceId3d()!=null&&!o.getResourceId3d().equals("")){
                    DimTourBas3dResource dimTourBas3dResource = new DimTourBas3dResource();
                    dimTourBas3dResource.setId(o.getResourceId3d());
                    List<DimTourBas3dResource> dimTourBas3dResources = dimTourBas3dResourceService.find(dimTourBas3dResource);
                    if(o.getResourceId()!=null&&!o.getResourceId().equals("")) {//查找到3d点位
                        dimTourBas3dResource = dimTourBas3dResources.get(0);
                        System.out.println(">>>>>>>>>>>>设备已有3d点位>>>>>>>>>>>>获取设备3d点位信息:"+dimTourBas3dResource.getName());//设备离线则形成一个离线/故障事件存储到运行事件
                        DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
                        dwdParkOptDevcEventInfo.setRelevanceId(dimTourBas3dResource.getId());//2维 区域报警 所以存储的是关联id字段存的是二维点位id
                        dwdParkOptDevcEventInfo.setType("3");//2视频 2维点位事件
                        dwdParkOptDevcEventInfo.setWarning("0");//0离线 2报警 3火灾 4周界告警   因为周界告警与离线告警若是同一个设备的话需要检索对应的时间进行闭环
                        List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
                        if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
                            System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备3d点位信息:"+dimTourBas3dResource.getName());
                            dwdParkOptDevcEventInfo = dwdParkOptDevcEventInfos.get(0);
                            if(status==1){//恢复正常 所以将事件闭环 将事件加到完成事件中
                                System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>在info中删除该事件");
                                dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
                                insertEventOver(dwdParkOptDevcEventInfo);
                            }
                        }else{
                            System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备3d点位信息:"+dimTourBas3dResource.getName());
                            if(status!=1){
                                String name = dimTourBas3dResource.getName()+"离线";
                                String address = dimTourBas3dResource.getAddress();
                                String warining = ""+status;
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
            }else{
                insertOrUpdateDevc(0,o,cameraName,regionIndexCode,channelNo,status,cameraType);
            }
        }
    }
    private void update(){

    }

    /**
     * 0 insert 1 update
     * @param flag
     * @param o
     * @param cameraName
     * @param regionIndexCode
     * @param channelNo
     * @param status
     * @param cameraType
     */
    private void insertOrUpdateDevc(int flag,DimTourDevcVideoSurveillance o,String cameraName,String regionIndexCode,String channelNo,int status,String cameraType){
        o.setName(cameraName);
        o.setCode(regionIndexCode);
        o.setChannel(channelNo);
        o.setStatus(status);
        o.setType(cameraType);
        o.setSort(1);
        Date now = new Date();
        o.setUpdateTime(now);
        if(flag==0){
            o.setCreateTime(now);
            System.out.println("数据库没有记录>>>>>>>>>>>>插入楼宇亮化设备信息:"+cameraName);
            dimTourDevcVideoSurveillanceService.insert(o);
        }else{
            o.setUpdateTime(now);
            System.out.println("数据库已有记录>>>>>>>>>>>>更新视频监控设备信息:"+o.getName());
        }
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

    /*****ping视频设备是否在线****/
    public void checkVideo(){
        DimTourDevcVideoSurveillance o = new DimTourDevcVideoSurveillance();
        List<DimTourDevcVideoSurveillance> dimTourDevcVideoSurveillances = dimTourDevcVideoSurveillanceService.find(o);
        for(DimTourDevcVideoSurveillance dimTourDevcVideoSurveillance:dimTourDevcVideoSurveillances){
            String ip = dimTourDevcVideoSurveillance.getIp();
            if(ip!=null&&!ip.equals("")){
                try {
                    if(Ping.ping(ip)){
                        dimTourDevcVideoSurveillance.setStatus(1);
                    }else{
                        dimTourDevcVideoSurveillance.setStatus(0);
                    }
                } catch (Exception ex) {
                    dimTourDevcVideoSurveillance.setStatus(0);
                }
            }else{
                dimTourDevcVideoSurveillance.setStatus(0);
            }
            dimTourDevcVideoSurveillanceService.update(o);
        }
    }
}
