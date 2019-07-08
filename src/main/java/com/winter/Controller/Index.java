package com.winter.Controller;


import com.winter.common.SendMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class Index {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }


    /**
     * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
     0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
     0 0 12 ? * WED 表示每个星期三中午12点 
     "0 0 12 * * ?" 每天中午12点触发 
     "0 15 10 ? * *" 每天上午10:15触发 
     "0 15 10 * * ?" 每天上午10:15触发 
     "0 15 10 * * ? *" 每天上午10:15触发 
     "0 15 10 * * ? 2005" 2005年的每天上午10:15触发 
     "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发 
     "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发 
     "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 
     "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发 
     "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发 
     "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发 
     "0 15 10 15 * ?" 每月15日上午10:15触发 
     "0 15 10 L * ?" 每月最后一日的上午10:15触发 
     "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发 
     "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发 
     "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
     */

    //监控点位
//    @Scheduled(fixedRate=10000)
    public void test(){
//        String url = "http://47.107.247.50:8099/RealTimeData.asmx?op=GetRealTimeDatas";
//        StringBuffer param = new StringBuffer();
//        param.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
//        param.append("  <soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
//        param.append("      <soap:Body>");
//        param.append("          <GetRealTimeDatas xmlns=\"http://cet-electric.com/\">");
//        param.append("              <MeasIds>32914</MeasIds>");
//        param.append("          </GetRealTimeDatas>");
//        param.append("      </soap:Body>");
//        param.append("</soap:Envelope>");
//        System.out.println(HttpRequestCET.doPost(url,param.toString()));
        SendMsg.MsgPost("17855827500","安昌","测试");
    }
}
