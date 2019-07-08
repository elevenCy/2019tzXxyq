package com.winter.model;

import java.util.List;

public class HikEvent {
    private String sendTime;//string	事件从接收者（如设备接入框架）发出的时间，格式 YYYY-mm-dd hh:MM:ss	是
    private String ability;//string;//事件类别，如视频事件、门禁事件	是	符合事件类型定义规范
    private String uids;//string;//指定的事件接收用户列表，用于事件源发起组件指定接收用户，如指定用户接收手动事件、在部分应用中可以设置事件到指定用户接收	否	通配所有用户

    public List<HikEventInfo> getEvents() {
        return events;
    }

    public void setEvents(List<HikEventInfo> events) {
        this.events = events;
    }

    private List<HikEventInfo> events;//json;//事件信息	是

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getUids() {
        return uids;
    }

    public void setUids(String uids) {
        this.uids = uids;
    }


    @Override
    public String toString() {
        return "HikEvent{" +
                "sendTime='" + isNotNull(sendTime) + '\'' +
                ", ability='" + isNotNull(ability) + '\'' +
                ", uids='" + isNotNull(uids) + '\'' +
                ", events=" + eventsIsNotNull(events) +
                '}';
    }
    public String isNotNull(Object obj){
        if(obj==null){
            return "null";
        }else{
            return obj.toString();
        }
    }
    public String eventsIsNotNull( List<HikEventInfo> events){
        if(events!=null&&!events.isEmpty()){
            String res = "[";
            for(HikEventInfo event:events){
                res += event.toString()+",";
            }
            res.substring(0,res.length()-1);
            res += "]";
            return res;
        }else{
            return "null";
        }
    }
}
