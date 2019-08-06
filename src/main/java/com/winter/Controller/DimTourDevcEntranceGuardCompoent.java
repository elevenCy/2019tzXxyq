package com.winter.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.winter.model.manage.dimTourDevcEntranceGuard.DimTourDevcEntranceGuard;
import com.winter.service.manage.dimTourDevcEntranceGuard.DimTourDevcEntranceGuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DimTourDevcEntranceGuardCompoent {

    private static final String IP_TRPE = "https://";
    private static final String ARTEMIS_PATH  = "/artemis";

    @Autowired
    private DimTourDevcEntranceGuardService dimTourDevcEntranceGuardService;
    @Scheduled(fixedRate=480000)
    public void requestList(){
        ArtemisConfig.host = "10.22.253.20:446";
        ArtemisConfig.appKey = "28325201";
        ArtemisConfig.appSecret  = "mlnirGmRGAGsq29fGLt3";
        final String api = ARTEMIS_PATH + "/api/resource/v1/acsDevice/acsDeviceList";
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put(IP_TRPE,api);
            }
        };
        String contentType = "application/json";
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("pageNo", 1);   //此参数非必填
        jsonBody.put("pageSize", 100);   //此参数非必填

        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType,null);
        System.out.println("请求路径："+ api + ",请求参数："+ body + ",返回结果：" + result);
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
                        analysisList(list);
                    }else{
                        System.out.println("获取解析成功>>>>>>>>>>>>列表为空");
                    }

                }else{
                    System.out.println("获取解析失败>>>>>>>>>>>>");
                }
            }
        }
    }
//    @RequestMapping("acsDeviceList")//取消已订阅事件
//    public String acsDeviceList_86(){
//        ArtemisConfig.host = "10.22.253.20:86";
//        ArtemisConfig.appKey = "28325201";
//        ArtemisConfig.appSecret  = "mlnirGmRGAGsq29fGLt3";
//        final String api = ARTEMIS_PATH + "/api/resource/v1/acsDevice/acsDeviceList";
//        Map<String,String> path = new HashMap<String,String>(2){
//            {
//                put(IP_TRPE,api);
//            }
//        };
//        String contentType = "application/json";
//        JSONObject jsonBody = new JSONObject();
//        jsonBody.put("pageNo", 1);   //此参数非必填
//        jsonBody.put("pageSize", 100);   //此参数非必填
//
//        String body = jsonBody.toJSONString();
//        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, contentType, null);
//        return result;
//    }
//    @RequestMapping("acsDeviceList")//取消已订阅事件
//    public String acsDeviceList_446(){
//        ArtemisConfig.host = "10.22.253.20:446";
//        ArtemisConfig.appKey = "28325201";
//        ArtemisConfig.appSecret  = "mlnirGmRGAGsq29fGLt3";
//        final String api = ARTEMIS_PATH + "/api/resource/v1/acsDevice/acsDeviceList";
//        Map<String,String> path = new HashMap<String,String>(2){
//            {
//                put(IP_TRPE,api);
//            }
//        };
//        String contentType = "application/json";
//        JSONObject jsonBody = new JSONObject();
//        jsonBody.put("pageNo", 1);   //此参数非必填
//        jsonBody.put("pageSize", 100);   //此参数非必填
//
//        String body = jsonBody.toJSONString();
//        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, contentType, null);
//        return result;
//    }
    public void analysisList(JSONArray list){
//                "acsDevIndexCode": "35750a57f20f4a2f989c399cd088ffde",//门禁设备唯一标识
//                "acsDevName": "fack",//	门禁设备名称
//                "acsDevTypeDesc": "123",//门禁设备类型描述
//                "acsDevTypeCode": "root000000",//门禁设备类型编号
//                "acsDevTypeName": "null",//门禁设备类型名称
//                "acsDevIp": "1.2.3.4",//门禁设备IP
//                "acsDevPort": "8000",//门禁设备port
//                "acsDevCode": "123",//门禁设备编号
//                "regionIndexCode": "123",//设备所属区域唯一标识
//                "treatyType": "123",//接入协议
//                "createTime": "2018-08-30T14:43:15.440+08:00",//创建时间
//                "updateTime": "2018-09-04T13:50:47.328+08:00"//更新时间
        for(int i=0;i<list.size();i++){
            JSONObject jsonObject = list.getJSONObject(i);
            String acsDevIndexCode = jsonObject.getString("acsDevIndexCode");
            String acsDevName = jsonObject.getString("acsDevName");
            String acsDevTypeDesc = jsonObject.getString("acsDevTypeDesc");
            String acsDevTypeName = jsonObject.getString("acsDevTypeName");
            String acsDevIp = jsonObject.getString("acsDevIp");
            String acsDevPort = jsonObject.getString("acsDevPort");
            String acsDevCode = jsonObject.getString("acsDevCode");
            String regionIndexCode = jsonObject.getString("regionIndexCode");
            String treatyType = jsonObject.getString("treatyType");
            String createTime = jsonObject.getString("createTime");
            String updateTime = jsonObject.getString("updateTime");
            DimTourDevcEntranceGuard dimTourDevcEntranceGuard = new DimTourDevcEntranceGuard();
            dimTourDevcEntranceGuard.setId(acsDevIndexCode);
            List<DimTourDevcEntranceGuard> localList = dimTourDevcEntranceGuardService.find(dimTourDevcEntranceGuard);
            Date now = new Date();
            if(localList!=null&&!localList.isEmpty()){
                dimTourDevcEntranceGuard = localList.get(0);
                dimTourDevcEntranceGuard.setName(acsDevName);
                dimTourDevcEntranceGuard.setTypeCode(acsDevTypeDesc);
                dimTourDevcEntranceGuard.setTypeName(acsDevTypeName);
                dimTourDevcEntranceGuard.setIp(acsDevIp);
                dimTourDevcEntranceGuard.setPort(acsDevPort);
                dimTourDevcEntranceGuard.setCode(acsDevCode);
                dimTourDevcEntranceGuard.setRegionIndexCode(regionIndexCode);
                dimTourDevcEntranceGuard.setTreatyType(treatyType);
                dimTourDevcEntranceGuard.setStatus(checkIsOnline(acsDevIp));
                dimTourDevcEntranceGuard.setUpdateTime(now);
                dimTourDevcEntranceGuardService.update(dimTourDevcEntranceGuard);
            }else{
                dimTourDevcEntranceGuard.setName(acsDevName);
                dimTourDevcEntranceGuard.setTypeCode(acsDevTypeDesc);
                dimTourDevcEntranceGuard.setTypeName(acsDevTypeName);
                dimTourDevcEntranceGuard.setIp(acsDevIp);
                dimTourDevcEntranceGuard.setPort(acsDevPort);
                dimTourDevcEntranceGuard.setCode(acsDevCode);
                dimTourDevcEntranceGuard.setRegionIndexCode(regionIndexCode);
                dimTourDevcEntranceGuard.setTreatyType(treatyType);
                dimTourDevcEntranceGuard.setStatus(checkIsOnline(acsDevIp));
                dimTourDevcEntranceGuard.setSort(1);
                dimTourDevcEntranceGuard.setCreateTime(now);
                dimTourDevcEntranceGuard.setUpdateTime(now);
                dimTourDevcEntranceGuardService.insert(dimTourDevcEntranceGuard);
            }
        }
    }

    public int checkIsOnline(String ip){
        ArtemisConfig.host = "10.22.253.20:446";
        ArtemisConfig.appKey = "28325201";
        ArtemisConfig.appSecret  = "mlnirGmRGAGsq29fGLt3";
        final String api = ARTEMIS_PATH + "/api/nms/v1/online/acs_device/get";
        Map<String,String> path = new HashMap<String,String>(2){
            {
                put(IP_TRPE,api);
            }
        };
        String contentType = "application/json";
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("ip", ip);   //此参数非必填

        String body = jsonBody.toJSONString();
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType);
        System.out.println("请求路径："+ api + ",请求参数："+ body + ",返回结果：" + result);
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
                        Integer online = list.getJSONObject(0).getInteger("online");
                        System.out.println("获取解析成功>>>>>>>>>>>>取0:"+list.getJSONObject(0).getInteger("online"));
                        if(online==null){
                            return 0;
                        }else{
                            return online;
                        }
                    }else{
                        System.out.println("获取解析成功>>>>>>>>>>>>列表为空");
                        return 0;
                    }

                }else{
                    System.out.println("获取解析失败>>>>>>>>>>>>");
                    return 0;
                }
            }
            return 0;
        }
        return 0;
    }
}
