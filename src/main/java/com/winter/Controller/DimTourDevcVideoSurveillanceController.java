package com.winter.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
public class DimTourDevcVideoSurveillanceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private  DimTourDevcVideoSurveillanceService dimTourDevcVideoSurveillanceService;
//
//    @Autowired
//    private DimTourBasAreaService dimTourBasAreaService;
//
//    @Autowired
//    private DimTourBasResourceService dimTourBasResourceService;
//
//    @Autowired
//    private DimTourBas3dResourceService dimTourBas3dResourceService;
//
//    @Autowired
//    private DwdParkOptDevcEventInfoService dwdParkOptDevcEventInfoService;
//
//    @Autowired
//    private DwdParkOptDevcEventInfoHistoryService dwdParkOptDevcEventInfoHistoryService;
//
//    private static final String IP_TRPE = "http://";
//    private static final String ARTEMIS_PATH  = "/artemis";
//
//    private static final String GET_CAMERAS = "/api/resource/v1/cameras";//此接口用来获取所有视频数据。
//
//    private void updateList( List<HikEventInfo> events){
//        for(HikEventInfo event:events){
//            DimTourDevcVideoSurveillance o = new DimTourDevcVideoSurveillance();
//            o.setId(event.getSrcIndex());
//            List<DimTourDevcVideoSurveillance> dimTourDevcVideoSurveillances = dimTourDevcVideoSurveillanceService.find(o);
//            if(dimTourDevcVideoSurveillances!=null&&!dimTourDevcVideoSurveillances.isEmpty()){
//                o = dimTourDevcVideoSurveillances.get(0);
//                if(o.getResourceId()!=null&&!o.getResourceId().equals("")){//查找到2d点位
//                    DimTourBasResource dimTourBasResource = new DimTourBasResource();
//                    dimTourBasResource.setId(o.getResourceId());
//                    List<DimTourBasResource> dimTourBasResources = dimTourBasResourceService.find(dimTourBasResource);
//                    if(dimTourBasResources!=null&&!dimTourBasResources.isEmpty()){
//                        dimTourBasResource = dimTourBasResources.get(0);
//                        System.out.println(">>>>>>>>>>>>设备已有2d点位>>>>>>>>>>>>获取设备2d点位信息:"+dimTourBasResource.getName());//设备离线则形成一个离线/故障事件存储到运行事件
//                        DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
//                        dwdParkOptDevcEventInfo.setRelevanceId(dimTourBasResource.getId());//2维 区域报警 所以存储的是关联id字段存的是二维点位id
//                        dwdParkOptDevcEventInfo.setWarning("0");//0离线 2报警 3火灾 4周界告警   因为周界告警与离线告警若是同一个设备的话需要检索对应的时间进行闭环
//                        dwdParkOptDevcEventInfo.setType("2");//2视频 2维点位事件
//                        List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
//                        if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
//                            System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备2d点位信息:"+dimTourBasResource.getName());
//                            dwdParkOptDevcEventInfo = dwdParkOptDevcEventInfos.get(0);
//                            dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
//                            insertEventOver(dwdParkOptDevcEventInfo);
//                        }else{
//                            System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备2d点位信息:"+dimTourBasResource.getName());
//                        }
//                        String name = dimTourBasResource.getName()+"周界告警";
//                        String address = dimTourBasResource.getAddress();
//                        String warining = "4";
//                        String content = dimTourBasResource.getAddress()+"-"+dimTourBasResource.getName()+":离线";
//                        insertEvent(dwdParkOptDevcEventInfo,name,address,warining,content,"2","0");
//                    }else{
//                        System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
//                    }
//                }else if(o.getResourceId3d()!=null&&!o.getResourceId3d().equals("")){
//                    DimTourBas3dResource dimTourBas3dResource = new DimTourBas3dResource();
//                    dimTourBas3dResource.setId(o.getResourceId3d());
//                    List<DimTourBas3dResource> dimTourBas3dResources = dimTourBas3dResourceService.find(dimTourBas3dResource);
//                    if(o.getResourceId()!=null&&!o.getResourceId().equals("")) {//查找到3d点位
//                        dimTourBas3dResource = dimTourBas3dResources.get(0);
//                        System.out.println(">>>>>>>>>>>>设备已有3d点位>>>>>>>>>>>>获取设备3d点位信息:"+dimTourBas3dResource.getName());//设备离线则形成一个离线/故障事件存储到运行事件
//                        DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
//                        dwdParkOptDevcEventInfo.setRelevanceId(dimTourBas3dResource.getId());//2维 区域报警 所以存储的是关联id字段存的是二维点位id
//                        dwdParkOptDevcEventInfo.setType("3");//2视频 2维点位事件
//                        dwdParkOptDevcEventInfo.setWarning("0");//0离线 2报警 3火灾 4周界告警   因为周界告警与离线告警若是同一个设备的话需要检索对应的时间进行闭环
//                        List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
//                        if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
//                            System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备3d点位信息:"+dimTourBas3dResource.getName());
//                            dwdParkOptDevcEventInfo = dwdParkOptDevcEventInfos.get(0);
//                            dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
//                            insertEventOver(dwdParkOptDevcEventInfo);
//                        }else{
//                            System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备3d点位信息:"+dimTourBas3dResource.getName());
//                        }
//                        String name = dimTourBas3dResource.getName()+"周界告警";
//                        String address = dimTourBas3dResource.getAddress();
//                        String warining = "4";
//                        String content = dimTourBas3dResource.getAddress()+"-"+dimTourBas3dResource.getName()+":离线";
//                        insertEvent(dwdParkOptDevcEventInfo,name,address,warining,content,"2","0");
//                    }else{
//                        System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
//                    }
//                }else{
//                    System.out.println(">>>>>>>>>>>>设备暂无点位");
//                }
//            }else{
//                System.out.println(">>>>>>>>>>>>数据库中没有找到该设备>>>>>>>>>>>>请注意");
//            }
//        }
//    }
//    private void insertEventOver(DwdParkOptDevcEventInfo o){
//        DwdParkOptDevcEventInfoHistory dwdParkOptDevcEventInfoHistory = new DwdParkOptDevcEventInfoHistory();
//        dwdParkOptDevcEventInfoHistory.setId(o.getId());
//        dwdParkOptDevcEventInfoHistory.setName(o.getName());
//        dwdParkOptDevcEventInfoHistory.setInfo(o.getInfo());
//        dwdParkOptDevcEventInfoHistory.setWarning(o.getWarning());
//        dwdParkOptDevcEventInfoHistory.setType(o.getType());
//        dwdParkOptDevcEventInfoHistory.setLevel(o.getLevel());
//        dwdParkOptDevcEventInfoHistory.setStatus(o.getStatus());
//        dwdParkOptDevcEventInfoHistory.setRelevanceId(o.getRelevanceId());
//        dwdParkOptDevcEventInfoHistory.setCreateTime(o.getCreateTime());
//        dwdParkOptDevcEventInfoHistory.setHappenTime(o.getHappenTime());
//        dwdParkOptDevcEventInfoHistory.setResolveTime(o.getResolveTime());
//        dwdParkOptDevcEventInfoHistory.setSolutionTime(new Date());
//
//        System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>将事件加入到历史表中");
//        dwdParkOptDevcEventInfoHistoryService.insert(dwdParkOptDevcEventInfoHistory);//加入到历史记录表中
//    }
//    private void insertEvent(DwdParkOptDevcEventInfo o,String name,String info,String waring,String content,String level,String status){
//        Date now = new Date();
//        o.setName(name);
//        o.setInfo(info);//地址
//        o.setWarning(waring);
//        o.setContent(content);
//        o.setLevel(level);//一般
//        o.setStatus(status);//未处理
//        o.setCreateTime(new Date());
//        o.setHappenTime(new Date());
//        o.setId(UuidUtil.get32UUID());
//        dwdParkOptDevcEventInfoService.insert(o);
//    }
//    @RequestMapping("eventRcv")
//    public void eventRcv(@RequestBody HikEventRcv hikEventRcv){
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println(df.format(new Date())+":"+hikEventRcv.toString());
//        DimTourDevcVideoSurveillance o = new DimTourDevcVideoSurveillance();
//        if(hikEventRcv!=null){
//            HikEvent params =  hikEventRcv.getParams();
//            if(params!=null){
//                List<HikEventInfo> events = params.getEvents();
//                if(events!=null&&!events.isEmpty()){
//                    updateList(events);
//                }else{
//                    System.out.println(">>>>>>>>>>>>收到周界告警事件>>>>>>>>>>>>解析 HikEventInfo 失败：请注意");
//                }
//            }else{
//                System.out.println(">>>>>>>>>>>>收到周界告警事件>>>>>>>>>>>>解析 HikEvent 失败：请注意");
//            }
//        }else{
//            System.out.println(">>>>>>>>>>>>收到周界告警事件>>>>>>>>>>>>解析 HikEventRcv 失败：请注意:");
//        }
//    }
//    @RequestMapping(value="/eventSubscriptionByEventTypes", method= RequestMethod.POST)//订阅事件
//    @ResponseBody
//    public String eventSubscriptionByEventTypes(int type){
//        /**
//         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
//         */
//        ArtemisConfig.host = "192.168.0.40:80";//网关服务器ip端口
//        ArtemisConfig.appKey = "25537814";//秘钥appkey
//        ArtemisConfig.appSecret  = "YbemWmvIV3kFyYRuzwWY";// 秘钥appSecret
//        /**
//         * STEP2：设置OpenAPI接口的上下文
//         */
//
//        /**
//         * STEP3：设置接口的URI地址
//         */
//        final String previewURLsApi = ARTEMIS_PATH + "/api/eventService/v1/eventSubscriptionByEventTypes";
//        Map<String, String> path = new HashMap<String, String>(2) {
//            {
//                put(IP_TRPE, previewURLsApi);//根据现场环境部署确认是http还是https
//            }
//        };
//
//        /**
//         * STEP4：设置参数提交方式
//         */
//        String contentType = "application/json";
//
//        /**
//         * STEP5：组装请求参数
//         */
//        JSONObject jsonBody = new JSONObject();
//        int[] arr = new int[]{type};
//        jsonBody.put("eventTypes", arr);
//        jsonBody.put("eventDest", "http://192.168.0.106:8071/eventRcv");
//        String body = jsonBody.toJSONString();
//        /**
//         * STEP6：调用接口
//         */
//        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType , null);// post请求application/json类型参数
//        return result;
//    }
//
//    @RequestMapping("eventUnSubscriptionByEventTypes")//取消已订阅事件
//    public String eventUnSubscriptionByEventTypes(int type){
//        /**
//         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
//         */
//        ArtemisConfig.host = "192.168.0.40:80";//网关服务器ip端口
//        ArtemisConfig.appKey = "25537814";//秘钥appkey
//        ArtemisConfig.appSecret  = "YbemWmvIV3kFyYRuzwWY";// 秘钥appSecret
//        /**
//         * STEP2：设置OpenAPI接口的上下文
//         */
//
//        /**
//         * STEP3：设置接口的URI地址
//         */
//        final String previewURLsApi = ARTEMIS_PATH + "/api/eventService/v1/eventUnSubscriptionByEventTypes";
//        Map<String, String> path = new HashMap<String, String>(2) {
//            {
//                put(IP_TRPE, previewURLsApi);//根据现场环境部署确认是http还是https
//            }
//        };
//        /**
//         * STEP4：设置参数提交方式
//         */
//        String contentType = "application/json";
//        /**
//         * STEP5：组装请求参数
//         */
//        JSONObject jsonBody = new JSONObject();
//        int[] arr = new int[]{type};
//        jsonBody.put("eventTypes", arr);
//        String body = jsonBody.toJSONString();
//        /**
//         * STEP6：调用接口
//         */
//        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType , null);// post请求application/json类型参数
//        return result;
//    }
//    @RequestMapping("eventSubscriptionView")//查看已订阅事件
//    public String eventSubscriptionView(){
//        /**
//         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
//         */
//        ArtemisConfig.host = "192.168.0.40:80";//网关服务器ip端口
//        ArtemisConfig.appKey = "25537814";//秘钥appkey
//        ArtemisConfig.appSecret  = "YbemWmvIV3kFyYRuzwWY";// 秘钥appSecret
//        /**
//         * STEP2：设置OpenAPI接口的上下文
//         */
//
//        /**
//         * STEP3：设置接口的URI地址
//         */
//        final String previewURLsApi = ARTEMIS_PATH + "/api/eventService/v1/eventSubscriptionView";
//        Map<String, String> path = new HashMap<String, String>(2) {
//            {
//                put(IP_TRPE, previewURLsApi);//根据现场环境部署确认是http还是https
//            }
//        };
//        /**
//         * STEP4：设置参数提交方式
//         */
//        String contentType = "application/json";
//        /**
//         * STEP5：组装请求参数
//         */
//        JSONObject jsonBody = new JSONObject();
//        String body = jsonBody.toJSONString();
//        /**
//         * STEP6：调用接口
//         */
//        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType , null);// post请求application/json类型参数
//        return result;
//    }
}
