package com.winter.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winter.common.HttpRequest;
import com.winter.model.manage.dwsTourWeatherMonitorRt.DwsTourWeatherMonitorRt;
import com.winter.service.manage.dwsTourWeatherMonitorRt.DwsTourWeatherMonitorRtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class DwsTourWeatherMonitorRtCompoent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DwsTourWeatherMonitorRtService dwsTourWeatherMonitorRtService;
//    @Scheduled(fixedRate=3600000) //2H
    public void getrWeatherMonitorRt(){
        String res = HttpRequest.doGet("https://free-api.heweather.com/s6/weather/now?key=270644c56e2f464091d39083bb83f23a&location=CN101210301&lang=zh-cn&unit=m");
        System.out.println(res);

        String code_img = "";
        String windDir ="";
        String type ="";
        String temperature ="";
        String hum ="";
        String windSc ="";

        JSONObject resJson = JSON.parseObject(res);
        JSONArray result5=resJson.getJSONArray("HeWeather6");//获取json数组
        JSONObject info5=result5.getJSONObject(0);
        //JSONObject basic5=info5.getJSONObject("basic");
        if(info5.getString("status").equals("ok")){
            JSONObject now5=info5.getJSONObject("now");

            code_img = now5.getString("cond_code");//获取天气图标
            windDir = now5.getString("wind_dir");//获取风力描述
            //天气
            type=now5.getString("cond_txt");//获取天气描述
            temperature=now5.getString("tmp");//获取当前温度
            hum=now5.getString("hum");//相对湿度
            windSc=now5.getString("wind_sc");//风力等级
        }

//        String name=basic5.getString("location");//获取地点信息
//        String windSpeed=now5.getString("wind_spd");//获取风速


        //秀洲区

        String qlty = "";
        String pm25 = "";
        res = HttpRequest.doGet("https://free-api.heweather.net/s6/air/now?key=270644c56e2f464091d39083bb83f23a&location=CN101210301&lang=zh-cn&unit=m");
        System.out.println(res);
        resJson = JSON.parseObject(res);
        result5=resJson.getJSONArray("HeWeather6");//获取json数组
        info5 = result5.getJSONObject(0);
        if(info5.getString("status").equals("ok")){
            JSONObject air_now_city =  info5.getJSONObject("air_now_city");
            qlty = air_now_city.getString("qlty");//获取空气质量
            pm25 = air_now_city.getString("pm25");//获取风速
        }
        //空气质量
        DwsTourWeatherMonitorRt dwsTourWeatherMonitorRt = new DwsTourWeatherMonitorRt();

        dwsTourWeatherMonitorRt.setCode("CN101210301");
        dwsTourWeatherMonitorRt.setTemperature(Integer.parseInt(temperature));
        dwsTourWeatherMonitorRt.setWindSpeed(windSc);
        dwsTourWeatherMonitorRt.setImgCode(code_img);
        dwsTourWeatherMonitorRt.setType(type);
        dwsTourWeatherMonitorRt.setWindDir(windDir);
        dwsTourWeatherMonitorRt.setHum(hum);
        dwsTourWeatherMonitorRt.setQlty(qlty);
        dwsTourWeatherMonitorRt.setPm25(pm25);
        dwsTourWeatherMonitorRt.setName("秀洲区");
        dwsTourWeatherMonitorRt.setCreatedate(new Date());
        dwsTourWeatherMonitorRtService.update(dwsTourWeatherMonitorRt);
    }
}
