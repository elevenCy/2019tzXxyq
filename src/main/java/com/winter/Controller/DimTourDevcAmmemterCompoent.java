package com.winter.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winter.common.HttpRequestCET;
import com.winter.common.UuidUtil;
import com.winter.common.XmlTool;
import com.winter.model.manage.dimTourBas3dResource.DimTourBas3dResource;
import com.winter.model.manage.dimTourDevcAmmeter.DimTourDevcAmmeter;
import com.winter.model.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfo;
import com.winter.model.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistory;
import com.winter.service.manage.dimTourBas3dResource.DimTourBas3dResourceService;
import com.winter.service.manage.dimTourBasArea.DimTourBasAreaService;
import com.winter.service.manage.dimTourDevcAmmeter.DimTourDevcAmmeterService;
import com.winter.service.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfoService;
import com.winter.service.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class DimTourDevcAmmemterCompoent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DimTourDevcAmmeterService dimTourDevcAmmeterService;

    @Autowired
    private DimTourBasAreaService dimTourBasAreaService;

    @Autowired
    private DimTourBas3dResourceService dimTourBas3dResourceService;

    @Autowired
    private DwdParkOptDevcEventInfoService dwdParkOptDevcEventInfoService;

    @Autowired
    private DwdParkOptDevcEventInfoHistoryService dwdParkOptDevcEventInfoHistoryService;
    //监控点位
//    @Scheduled(fixedRate=5000)
    public void requestList(){
        String url = "http://192.168.0.13:9630/ReadMeasuresConfig.asmx?op=GetMeasConfig";
        StringBuffer param = new StringBuffer();
        param.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        param.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        param.append("  <soap:Body>");
        param.append("      <GetMeasConfig xmlns=\"http://tempuri.org/\"/>");
        param.append("   </soap:Body>");
        param.append("</soap:Envelope>");

        String res = HttpRequestCET.doPost(url,param.toString());
        if(res!=null&&!res.isEmpty()){
            System.out.println(res);
            JSONObject jsonObject = XmlTool.documentToJSONObject(res);
            System.out.println(jsonObject.toString());
            JSONArray bodys = jsonObject.getJSONArray("Body");
            JSONObject resJson = null;
            if(!bodys.isEmpty()){
                JSONObject body = null;
                body = bodys.getJSONObject(0);
                System.out.println("body:"+body.toString());
                JSONArray GetMeasConfigResponses = body.getJSONArray("GetMeasConfigResponse");
                if(!GetMeasConfigResponses.isEmpty()){
                    JSONObject GetMeasConfigResponse = null;
                    GetMeasConfigResponse = GetMeasConfigResponses.getJSONObject(0);
                    System.out.println("GetMeasConfigResponse:"+GetMeasConfigResponse.toString());
                    String GetMeasConfigResult = GetMeasConfigResponse.getString("GetMeasConfigResult");
                    System.out.println("GetMeasConfigResult:"+GetMeasConfigResult);
                    resJson = JSON.parseObject(GetMeasConfigResult);
                    System.out.println("resJson:"+resJson.toString());
                }else{
                    System.out.println("GetMeasConfigResponse:解析失败");
                }
            }else{
                System.out.println("body:解析失败");
            }
            if(resJson!=null&&resJson.getBoolean("Success")&&resJson.getInteger("StatusCode")==0){
                JSONArray listJson = resJson.getJSONArray("ResultList");

                List<DimTourDevcAmmeter> os = new ArrayList<DimTourDevcAmmeter>();
                DimTourDevcAmmeter o = new DimTourDevcAmmeter();
                String MeasIds =  "";
                Date now = new Date();

                for(int j=0;j<listJson.size();j++) {
                    String MeasId = listJson.getJSONObject(j).getString("MeasId"); //测点ID
                    String MeasName = listJson.getJSONObject(j).getString("MeasName");//测点名称
                    String DeviceId = listJson.getJSONObject(j).getString("DeviceId");///设备ID
                    String DeviceName = listJson.getJSONObject(j).getString("DeviceName");//设备名称
                    String ChannelName = listJson.getJSONObject(j).getString("ChannelName");//通道名称
                    o.setId(MeasId);
                    o.setMeasId(MeasId);
                    o.setMeasName(MeasName);
                    o.setDeviceId(DeviceId);
                    o.setDeviceName(DeviceName);
                    o.setChannelName(ChannelName);
                    o.setStatus(0);
                    o.setCreateTime(now);
                    o.setUpdateTime(now);
                    MeasIds = MeasIds + MeasId+",";
                    os.add(o);
                }
                MeasIds = MeasIds.substring(0,MeasIds.length()-1);
                getRealTimeDatas(os,MeasIds);
            }else{
                System.out.println(resJson.getString("ErrorMessage"));
            }
        }else{
            System.out.println("请求失败");
        }
    }
    /*获取设备的实时数据*/
    private void getRealTimeDatas(List<DimTourDevcAmmeter>  dimTourDevcAmmeters, String MeasIds){
        String url = "http://192.168.0.13:9630/RealTimeData.asmx?op=GetRealTimeDatas";
        StringBuffer param = new StringBuffer();
        System.out.println(MeasIds);
        param.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        param.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        param.append("      <soap:Body>");
        param.append("          <GetRealTimeDatas xmlns=\"http://cet-electric.com/\">");
        param.append("              <MeasIds>"+MeasIds+"</MeasIds>");
        param.append("          </GetRealTimeDatas>");
        param.append("      </soap:Body>");
        param.append("</soap:Envelope>");
        String res = HttpRequestCET.doPost(url,param.toString());
        if(res!=null&&!res.isEmpty()){
            System.out.println(res);
            JSONObject jsonObject = XmlTool.documentToJSONObject(res);
            System.out.println(jsonObject.toString());
            JSONArray bodys = jsonObject.getJSONArray("Body");
            JSONObject resJson = null;
            if(!bodys.isEmpty()){
                JSONObject body = null;
                body = bodys.getJSONObject(0);
                System.out.println("body:"+body.toString());
                JSONArray GetMeasConfigResponses = body.getJSONArray("GetRealTimeDatasResponse");
                if(!GetMeasConfigResponses.isEmpty()){
                    JSONObject GetMeasConfigResponse = null;
                    GetMeasConfigResponse = GetMeasConfigResponses.getJSONObject(0);
                    System.out.println("GetRealTimeDatasResponse:"+GetMeasConfigResponse.toString());
                    String GetRealTimeDatasResult = GetMeasConfigResponse.getString("GetRealTimeDatasResult");
                    System.out.println("GetRealTimeDatasResult:"+GetRealTimeDatasResult);
                    resJson = JSON.parseObject(GetRealTimeDatasResult);
                    System.out.println("resJson:"+resJson.toString());
                }else{
                    System.out.println("GetMeasConfigResponse:解析失败");
                }
            }else{
                System.out.println("body:解析失败");
            }
            if(resJson!=null&&resJson.getBoolean("Success")&&resJson.getInteger("StatusCode")==0){
                JSONArray listJson = resJson.getJSONArray("ResultList");
                for(int i=0;i<dimTourDevcAmmeters.size();i++){
                    for(int j=0;j<listJson.size();j++) {
                        if(listJson.getJSONObject(j).getString("measID").equals(dimTourDevcAmmeters.get(i).getId())){
                            dimTourDevcAmmeters.get(i).setValue(listJson.getJSONObject(j).getString("val"));
                            dimTourDevcAmmeters.get(i).setStatus(1);
                        }
                    }
                }
            }else{
                System.out.println(resJson.getString("ErrorMessage"));
            }
        }else{
            System.out.println("请求失败");
        }
    }

    private void updateList(List<DimTourDevcAmmeter> dimTourDevcAmmeters){
        for (DimTourDevcAmmeter dimTourDevcAmmeter:dimTourDevcAmmeters) {
            List<DimTourDevcAmmeter> os = dimTourDevcAmmeterService.find(dimTourDevcAmmeter);
            if(os!=null&&!os.isEmpty()){
                System.out.println("数据库已有记录>>>>>>>>>>>>更新电表设备信息:");
                DimTourDevcAmmeter o = os.get(0);

                o.setMeasName(dimTourDevcAmmeter.getMeasName());
                o.setDeviceId(dimTourDevcAmmeter.getDeviceId());
                o.setDeviceName(dimTourDevcAmmeter.getDeviceName());
                o.setChannelName(dimTourDevcAmmeter.getChannelName());
                o.setStatus(dimTourDevcAmmeter.getStatus());
                o.setUpdateTime(dimTourDevcAmmeter.getUpdateTime());

                int status = o.getStatus();

                dimTourDevcAmmeterService.update(o);
                if(o.getResourceId3d()!=null&&!o.getResourceId3d().equals("")){//查找到点位
                    DimTourBas3dResource dimTourBas3dResource = new DimTourBas3dResource();
                    dimTourBas3dResource.setId(o.getResourceId3d());
                    List<DimTourBas3dResource> dimTourBas3dResources = dimTourBas3dResourceService.find(dimTourBas3dResource);
                    if(dimTourBas3dResources!=null&&!dimTourBas3dResources.isEmpty()){
                        dimTourBas3dResource = dimTourBas3dResources.get(0);
                        System.out.println(">>>>>>>>>>>>设备已有点位>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                        //设备离线则形成一个离线/故障事件存储到运行事件
                        DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo = new DwdParkOptDevcEventInfo();
                        dwdParkOptDevcEventInfo.setRelevanceId(dimTourBas3dResource.getId());
                        dwdParkOptDevcEventInfo.setType("3");//3维点位事件
                        List<DwdParkOptDevcEventInfo> dwdParkOptDevcEventInfos= dwdParkOptDevcEventInfoService.find(dwdParkOptDevcEventInfo);
                        if(dwdParkOptDevcEventInfos!=null&&!dwdParkOptDevcEventInfos.isEmpty()){
                            System.out.println(">>>>>>>>>>>>设备事件已存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
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
                            }
                        }else{
                            System.out.println(">>>>>>>>>>>>设备事件不存在>>>>>>>>>>>>获取设备点位信息:"+dimTourBas3dResource.getName());
                            if(status!=1){
                                dwdParkOptDevcEventInfo.setId(UuidUtil.get32UUID());
                                dwdParkOptDevcEventInfo.setInfo(dimTourBas3dResource.getAddress());
                                dwdParkOptDevcEventInfo.setWarning(""+status);
                                dwdParkOptDevcEventInfo.setLevel("2");//一般
                                dwdParkOptDevcEventInfo.setStatus("0");//未处理
                                dwdParkOptDevcEventInfo.setCreateTime(new Date());
                                dwdParkOptDevcEventInfo.setHappenTime(new Date());
                                if(status==0){//离线
                                    dwdParkOptDevcEventInfo.setName(dimTourBas3dResource.getName()+"离线");
                                    dwdParkOptDevcEventInfo.setContent(dimTourBas3dResource.getAddress()+"-"+dimTourBas3dResource.getName()+":离线");
                                }
                                dwdParkOptDevcEventInfoService.insert(dwdParkOptDevcEventInfo);
                            }
                        }
                    }else{
                        System.out.println(">>>>>>>>>>>>设备暂无点位>>>>>>>>>>>>点位被删除");
                    }
                }else{
                    System.out.println(">>>>>>>>>>>>设备暂无点位");
                }
            }else{
                System.out.println("数据库没有记录>>>>>>>>>>>>插入电表设备信息:");
                dimTourDevcAmmeter.setId(UuidUtil.get32UUID());
                dimTourDevcAmmeterService.insert(dimTourDevcAmmeter);
            }
        }
    }
}
