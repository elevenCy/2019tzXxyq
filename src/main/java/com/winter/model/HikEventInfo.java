package com.winter.model;

import com.alibaba.fastjson.JSONObject;

public class HikEventInfo {
    private String eventId;//string 事件Id，唯一标识事件的一次发生，同一事件发送多次需要ID相同	是	唯一标识,最大64字节
    private String srcIndex;//string	事件源编号，物理设备是资源编号	是	最大64字节
    private String srcType;//string	事件源类型	是	资源类型码
    private String srcName;//string	事件源名称，utf8	否	透传，应用自定义
    private Integer eventType;//Integer	事件类型	是
    private Integer status;//Integer	事件状态, 0-瞬时 1-开始 2-停止 3-事件脉冲 4-事件联动结果更新 5-异步图片上传	是	0,1,2,3,4,5
    private Integer eventLvl;//Integer	事件等级：0-未配置 1-低 2-中 3-高，注意，此处事件等级是指在事件联动中配置的等级	否	数字整型，0、1、2 、3，默认0
    private Integer timeout;//Integer	脉冲超时时间，一个持续性的事件，上报的间隔	是
    private String happenTime;//string	事件发生时间	是
    private String srcParentIndex;//string	事件发生的事件源父设备，无-空字符串	否	最大64字节
    private JSONObject data;//json	事件其它扩展信息	否	不同类型的事件，扩展信息不同，具体信息可查看具体事件的报文
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSrcIndex() {
        return srcIndex;
    }

    public void setSrcIndex(String srcIndex) {
        this.srcIndex = srcIndex;
    }

    public String getSrcType() {
        return srcType;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEventLvl() {
        return eventLvl;
    }

    public void setEventLvl(Integer eventLvl) {
        this.eventLvl = eventLvl;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(String happenTime) {
        this.happenTime = happenTime;
    }

    public String getSrcParentIndex() {
        return srcParentIndex;
    }

    public void setSrcParentIndex(String srcParentIndex) {
        this.srcParentIndex = srcParentIndex;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HikEventInfo{" +
                "eventId='" + isNotNull(eventId) + '\'' +
                ", srcIndex='" + isNotNull(srcIndex) + '\'' +
                ", srcType='" + isNotNull(srcType) + '\'' +
                ", srcName='" + isNotNull(srcName) + '\'' +
                ", eventType=" + isNotNull(eventType) +
                ", status=" + isNotNull(status) +
                ", eventLvl=" + isNotNull(eventLvl) +
                ", timeout=" + isNotNull(timeout) +
                ", happenTime='" + isNotNull(happenTime) + '\'' +
                ", srcParentIndex='" + isNotNull(srcParentIndex)+ '\'' +
                ", data=" + isNotNull(data) +
                '}';
    }
    public String isNotNull(Object obj){
        if(obj==null){
            return "null";
        }else{
            return obj.toString();
        }
    }
}
