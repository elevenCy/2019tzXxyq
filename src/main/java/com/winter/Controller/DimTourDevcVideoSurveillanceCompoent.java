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
import com.winter.service.manage.dimTourBas3dResource.DimTourBas3dResourceService;
import com.winter.service.manage.dimTourBasArea.DimTourBasAreaService;
import com.winter.service.manage.dimTourBasResource.DimTourBasResourceService;
import com.winter.service.manage.dimTourDevcVideoSurveillance.DimTourDevcVideoSurveillanceService;
import com.winter.service.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfoService;
import com.winter.service.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    private static final String IP_TRPE = "https://";
    private static final String ARTEMIS_PATH  = "/artemis";

    private static final String FIND_CAMERA_INFO_PAGE_BY_TREENODE = "/api/common/v1/remoteControlUnitRestService/findCameraInfoPageByTreeNode";//此接口用来获取所有视频数据。

//    private static final String PREVIEWURLS = "/api/video/v1/cameras/previewURLs";
    //照明设备
    @Scheduled(fixedRate=30000)
    public void requestList(){
        ArtemisConfig.host = "111.1.24.130:443";
        ArtemisConfig.appKey = "24828082";
        ArtemisConfig.appSecret  = "GFklVz8elwzwou4bmGWx";
        final String api = ARTEMIS_PATH + FIND_CAMERA_INFO_PAGE_BY_TREENODE;
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put(IP_TRPE,api);
            }
        };
        String contentType = "application/json";
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("treeNode","33100202002160626699");
        jsonBody.put("start", 0);   //此参数非必填 第几页开始，起始值0
        jsonBody.put("size", 200);   //此参数非必填	每页大小
        jsonBody.put("order", "desc");   //此参数非必填	不支持排序
        jsonBody.put("orderby", "createTime");   //此参数非必填	不支持排序

        String body = "{\"query\":"+jsonBody.toJSONString()+"}";//jsonBody.toJSONString();

        Map<String,String> querys = new HashMap<String,String>();
        querys.put("treeNode","33100202002160626699");
        querys.put("start", "0");
        querys.put("size", "200");
        querys.put("order", "desc");
        querys.put("orderby", "createTime");
        String result = ArtemisHttpUtil.doGetArtemis(path,querys,null,null);
//        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType);
        System.out.println("请求路径："+ api + ",请求参数："+ body + ",返回结果：" + result);
        JSONObject resJson = null;
        if(result!=null&&!result.equals("")){
            resJson = JSON.parseObject(result);
        }
        if(resJson!=null){
////            code	String	响应码:200成功，300失败
//              msg     String  消息
//              page    object {}
//                      page  int
//                      size  int
//                      total int
//                      total int
////            data	Array []	数据内容
            String code = resJson.getString("code");
            if(code!=""&&code.equals("200")){
                JSONObject page = resJson.getJSONObject("page");
                JSONArray data = resJson.getJSONArray("data");
                System.out.println("获取列表成功>>>>>>>>>>>>");
                if(page!=null&&data!=null){
                    Integer pageNo = page.getInteger("page");
                    Integer pageSize = page.getInteger("size");
                    Integer total = page.getInteger("total");
                    System.out.println("获取解析成功>>>>>>>>>>>>total:"+total+">>>>>>>>>>>>pageNo:"+pageNo+">>>>>>>>>>>>pageSize:"+pageSize);
                    if(data!=null&&!data.isEmpty()){
                        updateList(data);
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
            String cameraId = l.getString("cameraId");//"cameraId": "1080",//通道Id
            String indexCode = l.getString("indexCode");//"indexCode": "33100202001310152316",//索引编号
            String name = l.getString("name");//"name": "春苗幼儿园-烹饪间",//控制点名称
            String parentIndexCode  = l.getString("parentIndexCode");//"parentIndexCode": "33100202002160626699",//父组织编号
            String cameraType = l.getString("cameraType");//"cameraType": 0,//摄像机类型 (0枪机,1半球,2快球3带云台枪机)
            String pixel = l.getString("pixel");// "pixel": 1,//摄像机类型 (0枪机,1半球,2快球3带云台枪机)
            String latitude = l.getString("latitude");// "latitude": "28.6221805855983",//纬度
            String longitude = l.getString("longitude");//  "longitude": "121.40015346798",//经度
            String description = l.getString("description");//"description": "",//描述
            Integer isOnline = l.getInteger("isOnline");//"isOnline": 0,//是否在线(1在线,0不在线)
            Integer updateTime = l.getInteger("updateTime");//"updateTime": 1561445541331,//更新时间
//            String extraField = l.getString("extraField");//扩展字段，内容是个json格式。一般不用，不同的监控点不一样，可忽略。
            if(name!=null&&name.indexOf("星星园区")!=-1){
                o.setId(cameraId);
                List<DimTourDevcVideoSurveillance> dimTourDevcVideoSurveillances = dimTourDevcVideoSurveillanceService.find(o);
                if(dimTourDevcVideoSurveillances!=null&&!dimTourDevcVideoSurveillances.isEmpty()){
                    o = dimTourDevcVideoSurveillances.get(0);
                    insertOrUpdateDevc(1,o,name,indexCode,isOnline,cameraType);
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
                                if(isOnline==1){//恢复正常 所以将事件闭环 将事件加到完成事件中
                                    System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>在info中删除该事件");
                                    dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
                                    insertEventOver(dwdParkOptDevcEventInfo);
                                }
                            }else{
                                System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备2d点位信息:"+dimTourBasResource.getName());
                                if(isOnline!=1){
                                    String eventName = dimTourBasResource.getName()+"离线";
                                    String address = dimTourBasResource.getAddress();
                                    String warining = ""+isOnline;
                                    String content = dimTourBasResource.getAddress()+"-"+dimTourBasResource.getName()+":离线";
                                    insertEvent(dwdParkOptDevcEventInfo,eventName,address,warining,content,"2","0");
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
                                if(isOnline==1){//恢复正常 所以将事件闭环 将事件加到完成事件中
                                    System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>在info中删除该事件");
                                    dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
                                    insertEventOver(dwdParkOptDevcEventInfo);
                                }
                            }else{
                                System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备3d点位信息:"+dimTourBas3dResource.getName());
                                if(isOnline!=1){
                                    String eventName = dimTourBas3dResource.getName()+"离线";
                                    String address = dimTourBas3dResource.getAddress();
                                    String warining = ""+isOnline;
                                    String content = dimTourBas3dResource.getAddress()+"-"+dimTourBas3dResource.getName()+":离线";
                                    insertEvent(dwdParkOptDevcEventInfo,eventName,address,warining,content,"2","0");
                                }
                            }
                        }else{
                            System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
                        }
                    }else{
                        System.out.println(">>>>>>>>>>>>设备暂无点位");
                    }
                }else{
                    insertOrUpdateDevc(0,o,name,indexCode,isOnline,cameraType);
                }
            }else{
                System.out.println(">>>>>>>>>>>>"+name+">>>>>>>>>>>>设备不属于星星园区");
            }
        }
    }
    private void update(){

    }

    /**
     * 0 insert 1 update
     * @param flag
     * @param o
     * @param name
     * @param indexcode
     * @param isOnline
     * @param cameraType
     */
    private void insertOrUpdateDevc(int flag,DimTourDevcVideoSurveillance o,String name,String indexCode,Integer isOnline,String cameraType){
        o.setName(name);//视频名称
        o.setCode(indexCode);
        o.setStatus(isOnline);
        o.setType(cameraType);
        o.setSort(1);
        Date now = new Date();
        o.setUpdateTime(now);
        if(flag==0){
            o.setCreateTime(now);
            System.out.println("数据库没有记录>>>>>>>>>>>>插入楼宇亮化设备信息:"+name+">>>>>>>>>>>>状态:"+isOnline);
            dimTourDevcVideoSurveillanceService.insert(o);
        }else{
            o.setUpdateTime(now);
            System.out.println("数据库已有记录>>>>>>>>>>>>更新视频监控设备信息:"+o.getName()+">>>>>>>>>>>>状态:"+isOnline);
            dimTourDevcVideoSurveillanceService.update(o);
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
