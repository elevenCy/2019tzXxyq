package com.winter.Controller;

import com.winter.common.HttpRequest;
import com.winter.common.MD5;
import com.winter.model.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController//请求
public class DwdParkOptDevcEventInfoController {

    private static final String IP_TRPE = "http://222.66.124.34:8082";
    private static final String sendSMS = "/sendMessage/sendSMS";
    @RequestMapping("sendWarning")//
    public String sendWarning(){
//        {
//            "apiKey": "XXXX",
//                "apiSign": "YYYYY",
//                "facility": "YYYY",
//                "facilityName": "设备",
//                "warningDegree": "1",
//                "warningName": "一般",
//                "location": "一号楼西侧",
//                "currentTime": "2019-07-01 16:30:24",
//                "warningDesc": "电器设备故障，出现明火"
//        }
        SortedMap<Object, Object> parameters = new TreeMap<Object,Object>();
//        parameters.put("apiKey","wQKrpm9fbHecYNxD");//标识
//        String apiSecret = "3251f017efaf07b5394da19c55428c4d";
//        String apiSign = MD5.encryption(apiSecret);
//        parameters.put("apiSign",apiSign);//签名
        parameters.put("eventId","xxxxxx");//设备类型id
        parameters.put("facility","b1af62e718854baf9fb73e036dd48002");//设备类型id
        parameters.put("facilityName","视频视频");
        parameters.put("warningDegree",1);
        parameters.put("warningName","一般");
        parameters.put("location","一号楼西侧");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        String nowStr = df.format(now);
        parameters.put("currentTime",nowStr);
        parameters.put("warningDesc","识破设备离线");
        getSignParms(parameters);
        String param = ChangeToString(parameters);
        System.out.println("ip:"+IP_TRPE+sendSMS);
        System.out.println(HttpRequest.doPost(IP_TRPE+sendSMS,param));
        return "success";
    }
    public void sendWarning(DwdParkOptDevcEventInfo dwdParkOptDevcEventInfo){
        SortedMap<Object, Object> parameters = new TreeMap<Object,Object>();
        parameters.put("eventId",dwdParkOptDevcEventInfo.getId());//设备类型id
        parameters.put("facility","");//设备类型id
//        "id": "b1af62e718854baf9fb73e036dd48000","itemValue": "水浸",
//        "id": "b1af62e718854baf9fb73e036dd48001","itemValue": "变电房",
//        "id": "b1af62e718854baf9fb73e036dd48002","itemValue": "视频监控",
//        "id": "b1af62e718854baf9fb73e036dd48003","itemValue": "灯控",
//        "id": "b1af62e718854baf9fb73e036dd48004","itemValue": "设备",
        parameters.put("facilityName",dwdParkOptDevcEventInfo.getName());
        parameters.put("warningDegree",dwdParkOptDevcEventInfo.getLevel());

        parameters.put("warningName",dwdParkOptDevcEventInfo.getLevel().equals("1")?"一般":"紧急");
        parameters.put("location",dwdParkOptDevcEventInfo.getInfo());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        String nowStr = df.format(now);
        parameters.put("currentTime",nowStr);
        parameters.put("warningDesc",dwdParkOptDevcEventInfo.getContent());
        getSignParms(parameters);
        String param = ChangeToString(parameters);
        System.out.println("ip:"+IP_TRPE+sendSMS);
        System.out.println(HttpRequest.doPost(IP_TRPE+sendSMS,param));
    }
    public static SortedMap<Object, Object> getSignParms(SortedMap<Object, Object> parameters){
        //所有参与传参的参数按照ASCII排序（升序）
        Set set = parameters.entrySet();
        Iterator it = set.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(entry.getValue());
        }
        Long timestamp = new Date().getTime() / 1000;
        System.out.println("同步的时间戳: " + timestamp );
        String str = "wQKrpm9fbHecYNxD" + sb.toString()+ "3251f017efaf07b5394da19c55428c4d";
        System.out.println("待加密串: " + str );
        String sign = MD5.encryption(str);
        System.out.println("加密结果小写: " + sign.toLowerCase() );

        parameters.put("apiKey", "wQKrpm9fbHecYNxD");
        parameters.put("apiSign", sign.toLowerCase());
        return parameters;
    }
    public static String ChangeToString(SortedMap<Object, Object> parameters){
        //所有参与传参的参数按照ASCII排序（升序）
        Set set = parameters.entrySet();
        Iterator it = set.iterator();
        StringBuffer sb = new StringBuffer("{");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append("\""+entry.getKey()+"\":\""+entry.getValue()+"\",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        String result = "{\"messageVo\":"+sb.toString()+"}";
        System.out.println("参数: " + result );
        return sb.toString();
    }
}
