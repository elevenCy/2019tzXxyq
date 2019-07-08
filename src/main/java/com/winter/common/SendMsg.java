package com.winter.common;

public class SendMsg {
    private static final String username = "hztj01";
    private static final String password = "999999";
    private static final String longnum = "8196";
    /**
     *
     * @param phonelist		需要发送的手机号，多个手机号以,分隔；例：13801010101,13801010102
     * @param msg	 短信标题；例：【中国电信】，参数传入中国电信即可
     * @param mess   短信内容
     * @return
     */
    public static String MsgGet(String phonelist,String msg,String mess) {
        String returnMsm = null;
        try {
            String url="http://101.200.228.238/NewSmsPort/default.asmx/SendSms";
            url+="?username="+username+"&password="+password+"&phonelist="+phonelist+"&msg=【"+msg+"】"+mess+"&longnum="+longnum;
            String response = HttpRequest.doGet(url);//HttpRequest.sendGet(url, null);
            if(response != null){
                response = response.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
                response = response.replace("<string xmlns=\"http://tempuri.org/\">", "");
                response = response.replace("</string>", "");
                response = response.trim();
                if("-1".equals(response)){
                    returnMsm = "帐号和密码验证失败或是帐号被注销!";
                }else if("-2".equals(response)){
                    returnMsm = "手机号码为空或含有不合法的手机号码!";
                }else if("-3".equals(response)){
                    returnMsm = "内容为空或含有非法字符!";
                }else if("-4".equals(response)){
                    returnMsm = "账号余额不足!";
                }else if("-5".equals(response)){
                    returnMsm = "内容长度不合法!";
                }else if("-6".equals(response)){
                    returnMsm = "低于起发限制!";
                }else if("-10".equals(response)){
                    returnMsm = "其他错误!";
                }else{
                    returnMsm = "短信发送成功!";
                }
            }
        } catch (Exception e) {
            returnMsm = "短信接口异常!异常内容:"+e.toString();
        }
        return returnMsm;
    }

    public static String MsgPost(String phonelist,String msg,String mess) {
        String returnMsm = null;
        try {
            String url="http://101.200.228.238/NewSmsPort/default.asmx/SendSms";
            String param = "username="+username+"&password="+password+"&phonelist="+phonelist+"&msg=【"+msg+"】"+mess+"&longnum="+longnum;
            String response = HttpRequest.doPost(url, param);

            if(response != null){
                response = response.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
                response = response.replace("<string xmlns=\"http://tempuri.org/\">", "");
                response = response.replace("</string>", "");
                response = response.trim();
                if("-1".equals(response)){
                    returnMsm = "帐号和密码验证失败或是帐号被注销!";
                }else if("-2".equals(response)){
                    returnMsm = "手机号码为空或含有不合法的手机号码!";
                }else if("-3".equals(response)){
                    returnMsm = "内容为空或含有非法字符!";
                }else if("-4".equals(response)){
                    returnMsm = "账号余额不足!";
                }else if("-5".equals(response)){
                    returnMsm = "内容长度不合法!";
                }else if("-6".equals(response)){
                    returnMsm = "低于起发限制!";
                }else if("-10".equals(response)){
                    returnMsm = "其他错误!";
                }else{
                    returnMsm = "短信提醒成功!";
                }
            }
        } catch (Exception e) {
            returnMsm = "短信接口异常!异常内容:"+e.toString();
        }
        return returnMsm;
    }


    public static void main(String[] args) throws Exception {
        String str ="17671230402";
        try {
            //BufferedReader br = new BufferedReader(new FileReader("E://这里输需要发送短信提醒的手机号(以'，'分隔).txt"));// 构造一个BufferedReader类来读取文件
            //str = br.readLine();
        } catch (Exception e) {
        }
        System.out.println(SendMsg.MsgGet(str,"报福",str));
    }
}
