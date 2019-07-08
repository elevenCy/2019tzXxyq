package com.winter.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winter.common.HttpRequest;
import com.winter.common.HttpRequestLight;
import com.winter.common.UuidUtil;
import com.winter.model.manage.dimTourBasArea.DimTourBasArea;
import com.winter.model.manage.dimTourBasResource.DimTourBasResource;
import com.winter.model.manage.dimTourDevcLight.DimTourDevcLight;
import com.winter.model.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfo;
import com.winter.model.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistory;
import com.winter.service.manage.dimTourBasArea.DimTourBasAreaService;
import com.winter.service.manage.dimTourBasResource.DimTourBasResourceService;
import com.winter.service.manage.dimTourDevcLight.DimTourDevcLightService;
import com.winter.service.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfoService;
import com.winter.service.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class DimTourDevcLightCompoent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DimTourDevcLightService dimTourDevcLightService;

    @Autowired
    private DimTourBasAreaService dimTourBasAreaService;

    @Autowired
    private DimTourBasResourceService dimTourBasResourceService;

    @Autowired
    private DwdParkOptDevcEventInfoService dwdParkOptDevcEventInfoService;

    @Autowired
    private DwdParkOptDevcEventInfoHistoryService dwdParkOptDevcEventInfoHistoryService;

    private static final String IP = "http://101.204.229.39:88";
    /*登陆*/
    private static final String LOGIN = "/API/User/Logon";
    private static final String LOGIN_CODE = "1001";
    /*设备列表*/
    private static final String LIST = "/API/Equip/List";
    private static final String LIST_CODE = "2001";

    private static final String USER_NAME = "name";
    private static final String USER = "hl20190325";
    private static final String PWD_NAME = "pwd";
    private static final String PWD = "hl20190325";
    private static final String PHONE_NAME = "phone";
    private static final String PHONE = "";

    //照明设备
//    @Scheduled(fixedRate=5000)
    public void requestList(){
        List<DimTourDevcLight> list = new ArrayList<DimTourDevcLight>();
        String url = IP + LOGIN;
        String param = "{" +
                "\"code\":" +LOGIN_CODE+","+
                "\""+USER_NAME+"\":\"" +USER+"\","+
                "\""+PWD_NAME+"\":\"" +PWD+"\","+
                "\""+PHONE_NAME+"\":\"" +PHONE+"\","+
                "}";

        String res = HttpRequest.doPost(url,param);
        JSONObject resJson = null;
        if(res!=null){
            System.out.println(res);
            resJson = JSON.parseObject(res);
        }
//        {
//            type:1
//                    ,result:true
//                ,data:{
//            user:1000
//                    ,name:"name"
//                    ,custName:""
//                    ,tip:"文字报警消息:..."
//                    ,token:”” }
//        }
        if(resJson!=null){
            String type = resJson.getString("type");
            boolean result = resJson.getBoolean("result");
            if(type.equals("1")&&result){
                JSONObject dataJson = resJson.getJSONObject("data");
                String user = dataJson.getString("user");
                String token = dataJson.getString("token");
                System.out.println("登陆成功>>>>>>>>>>>>获取user:"+user+">>token:"+token);
                url = IP+LIST;
                int page = 0;
                resJson = httpGetList(url,page,token,user);
                if(resJson!=null&&resJson.getString("type").equals("1")&&resJson.getBoolean("result")){
                    dataJson = resJson.getJSONObject("data");
                    JSONArray lists = dataJson.getJSONArray("list");
                    int total = dataJson.getInteger("total");
                    if(lists!=null&&!lists.isEmpty()){
                        int size = lists.size();
                        int pageNum =  total/size;
                        System.out.println("获取列表成功>>>>>>>>>>>>列表总数:"+total+">>分页数:"+pageNum+">>页:"+page+">>记录数:"+size+">>页大小:"+size);
                        updateList(lists);
                        if(lists.size()<total){
                            for(int i=1;i<=pageNum;i++){
                                page = i;
                                resJson = httpGetList(url,page,token,user);
                                lists = resJson.getJSONArray("data");
                                System.out.println("获取列表成功>>>>>>>>>>>>列表总数:"+total+">>分页数:"+pageNum+">>页:"+page+">>记录数:"+lists.size()+">>页大小:"+size);
                                if(lists!=null&&!lists.isEmpty()){
                                    updateList(lists);
                                }
                            }
                        }
                    }
                }else{
                    System.out.println( resJson.getString("msg"));
                }

            }else{
                System.out.println( resJson.getString("msg"));
            }
        }else{
            System.out.println("请求异常");
        }
    }
    private JSONObject httpGetList(String url,int page,String token,String user){
        String  param = "{" +
                "\"code\":" +LIST_CODE+","+
                "\"user\":\"" +user+"\","+
                "\"page\":"+page+""+
                "}";
        String res = HttpRequestLight.doPost(token,user,url,param);
        if(res==null){
            System.out.println("请求异常");
            return null;
        }else{
            System.out.println(res);
            return JSON.parseObject(res);
        }
    }
    private void updateList(JSONArray lists){
        DimTourDevcLight o = new DimTourDevcLight();
        JSONObject l;
        for(int i=0;i<lists.size();i++){
            l = lists.getJSONObject(i);
            String eqid = l.getString("eqid");//"eqid": 5680,
            String eqno = l.getString("eqno");//"eqno": "10190325004",
            String eqcode = l.getString("eqcode");//        "eqcode": null,
            String name = l.getString("name");//        "name": "ETW104Y 01",
            String type = l.getString("type");//        "type": "ETW",
            String addr = l.getString("addr");//        "addr": null,
            int status = l.getInteger("status");//        "status": 2,:0 关灯状态1 正常、2离线、3 报警
            if(status==0){
                status = 1;//我们数据库字典里存储的是 关灯状态时默认在线->1
            }
            if(status==2){
                status = 0;//我们数据库字典里存储的是 离线->0
            }
            if(status==3){
                status = 2;//我们数据库字典里存储的是 报警->2
            }
            String group = l.getString("group");//        "group": "",
            String lon = l.getString("lon");//        "lon": 120.708791,
            String lat = l.getString("lat");//        "lat": 30.781384,
            String hlStatus = l.getString("hlStatus");//        "hlStatus": "0000000000000000",
            String lights = l.getString("lights");//        "lights": []
            o.setId(eqid);
            List<DimTourDevcLight> dimTourDevcLights = dimTourDevcLightService.find(o);
            if(dimTourDevcLights!=null&&!dimTourDevcLights.isEmpty()){
                o = dimTourDevcLights.get(0);
                o.setEqid(eqid);
                o.setEqno(eqno);
                o.setEqcode(eqcode);
                o.setName(name);
                o.setType(type);
                o.setAddr(addr);
                o.setStatus(status);
                o.setGroup(group);
                o.setLon(lon);
                o.setLat(lat);
                o.setHlStatus(hlStatus);
                o.setLights(lights);
                o.setSort(1);
                Date now = new Date();
                o.setUpdateTime(now);
                System.out.println("数据库已有记录>>>>>>>>>>>>更新楼宇亮化设备信息:"+eqid);

                dimTourDevcLightService.update(o);
                if(o.getResourceId()!=null&&!o.getResourceId().equals("")){//查找到点位
                    DimTourBasResource dimTourBasResource = new DimTourBasResource();
                    dimTourBasResource.setId(o.getResourceId());
                    List<DimTourBasResource> dimTourBasResources = dimTourBasResourceService.find(dimTourBasResource);
                    if(dimTourBasResources!=null&&!dimTourBasResources.isEmpty()){
                        dimTourBasResource = dimTourBasResources.get(0);
                        System.out.println(">>>>>>>>>>>>设备已有点位>>>>>>>>>>>>获取设备点位信息:"+dimTourBasResource.getName());
                        //设备离线则形成一个离线/故障事件存储到运行事件
                        DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
                        dwdParkOptDevcEventInfo.setRelevanceId(dimTourBasResource.getId());//2维 区域报警 所以存储的是关联id字段存的是二维点位id
                        dwdParkOptDevcEventInfo.setType("2");//2景观灯 2维点位事件
                        List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
                        if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
                            System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBasResource.getName());
                            dwdParkOptDevcEventInfo = dwdParkOptDevcEventInfos.get(0);
                            if(status==1){//恢复正常 所以将事件闭环 将事件加到完成事件中
                                System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>在info中删除该事件");
                                dwdParkOptDevcEventInfoService.delete(dwdParkOptDevcEventInfo);//在info表中删除
                                DwdParkOptDevcEventInfoHistory dwdParkOptDevcEventInfoHistory = new DwdParkOptDevcEventInfoHistory();
                                dwdParkOptDevcEventInfoHistory.setId(dwdParkOptDevcEventInfo.getId());
                                dwdParkOptDevcEventInfoHistory.setName(dwdParkOptDevcEventInfo.getName());
                                dwdParkOptDevcEventInfoHistory.setInfo(dwdParkOptDevcEventInfo.getInfo());
                                dwdParkOptDevcEventInfoHistory.setWarning(dwdParkOptDevcEventInfo.getWarning());
                                dwdParkOptDevcEventInfoHistory.setType(dwdParkOptDevcEventInfo.getType());
                                dwdParkOptDevcEventInfoHistory.setLevel(dwdParkOptDevcEventInfo.getLevel());
                                dwdParkOptDevcEventInfoHistory.setStatus(dwdParkOptDevcEventInfo.getStatus());
                                dwdParkOptDevcEventInfoHistory.setRelevanceId(dwdParkOptDevcEventInfo.getRelevanceId());
                                dwdParkOptDevcEventInfoHistory.setCreateTime(dwdParkOptDevcEventInfo.getCreateTime());
                                dwdParkOptDevcEventInfoHistory.setHappenTime(dwdParkOptDevcEventInfo.getHappenTime());
                                dwdParkOptDevcEventInfoHistory.setResolveTime(dwdParkOptDevcEventInfo.getResolveTime());
                                dwdParkOptDevcEventInfoHistory.setSolutionTime(new Date());
                                System.out.println(">>>>>>>>>>>>设备恢复正常>>>>>>>>>>>>将事件加入到历史表中");
                                dwdParkOptDevcEventInfoHistoryService.insert(dwdParkOptDevcEventInfoHistory);//加入到历史记录表中
                            }else{
                                if(!dwdParkOptDevcEventInfo.getWarning().equals(""+status)){//事件变更状态
                                    dwdParkOptDevcEventInfo.setWarning(""+status);
                                    if(status==0){//离线
                                        System.out.println(">>>>>>>>>>>>设备离线>>>>>>>>>>>>添加事件");
                                        dwdParkOptDevcEventInfo.setContent(dimTourBasResource.getAddress()+"-"+dimTourBasResource.getName()+":离线");
                                        dwdParkOptDevcEventInfo.setName(dimTourBasResource.getName()+"离线");
                                    }
                                    if(status==2){//报警
                                        System.out.println(">>>>>>>>>>>>设备报警>>>>>>>>>>>>添加事件");
                                        dwdParkOptDevcEventInfo.setName(dimTourBasResource.getName()+"报警");
                                        dwdParkOptDevcEventInfo.setContent(dimTourBasResource.getAddress()+"-"+dimTourBasResource.getName()+":报警");
                                    }
                                    dwdParkOptDevcEventInfo.setHappenTime(new Date());
                                    dwdParkOptDevcEventInfoService.update(dwdParkOptDevcEventInfo);
                                }
                            }
                        }else{
                            System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBasResource.getName());
                            if(status!=1){
                                dwdParkOptDevcEventInfo.setId(UuidUtil.get32UUID());
                                dwdParkOptDevcEventInfo.setInfo(dimTourBasResource.getAddress());
                                dwdParkOptDevcEventInfo.setWarning(""+status);
                                dwdParkOptDevcEventInfo.setLevel("2");//一般
                                dwdParkOptDevcEventInfo.setStatus("0");//未处理
                                dwdParkOptDevcEventInfo.setCreateTime(new Date());
                                dwdParkOptDevcEventInfo.setHappenTime(new Date());
                                if(status==0){//离线
                                    dwdParkOptDevcEventInfo.setName(dimTourBasResource.getName()+"离线");
                                    dwdParkOptDevcEventInfo.setContent(dimTourBasResource.getAddress()+"-"+dimTourBasResource.getName()+":离线");
                                }
                                if(status==2){//报警
                                    dwdParkOptDevcEventInfo.setName(dimTourBasResource.getName()+"报警");
                                    dwdParkOptDevcEventInfo.setContent(dimTourBasResource.getAddress()+"-"+dimTourBasResource.getName()+":报警");
                                }
                                dwdParkOptDevcEventInfoService.insert(dwdParkOptDevcEventInfo);
                            }
                        }
                        //设备离线则形成一个离线/故障事件存储到运行事件
                        DimTourBasArea dimTourBasArea = new DimTourBasArea();
                        dimTourBasArea.setId(dimTourBasResource.getAreaId());
                        dimTourBasArea.setHlStatus(hlStatus);
                        dimTourBasArea.setUpdateTime(new Date());
                        System.out.println(">>>>>>>>>>>>更新大楼状态");
                        dimTourBasAreaService.update(dimTourBasArea);
                    }else{
                        System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
                    }
                }else{
                    System.out.println(">>>>>>>>>>>>设备暂无点位");
                }
            }else{
                o.setEqid(eqid);
                o.setEqno(eqno);
                o.setEqcode(eqcode);
                o.setName(name);
                o.setType(type);
                o.setAddr(addr);
                o.setStatus(status);
                o.setGroup(group);
                o.setLon(lon);
                o.setLat(lat);
                o.setHlStatus(hlStatus);
                o.setLights(lights);
                o.setSort(1);
                Date now = new Date();
                o.setCreateTime(now);
                o.setUpdateTime(now);
                System.out.println("数据库没有记录>>>>>>>>>>>>插入楼宇亮化设备信息:"+eqid);
                dimTourDevcLightService.insert(o);
            }
        }
    }
}
