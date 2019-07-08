package com.winter.model;

public class HikEventRcv {
    private String method;//string	方法名，用于标识报文用途	是	事件固定OnEventNotify

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private HikEvent params;//string	事件参数信息	是	具体参数信息

    public HikEvent getParams() {
        return params;
    }

    public void setParams(HikEvent params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "HikEventRcv{" +
                "method='" + isNotNull(method) + '\'' +
                ", param=" + isNotNull(params) +
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
