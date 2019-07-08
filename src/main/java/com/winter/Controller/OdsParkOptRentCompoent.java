package com.winter.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winter.common.HttpRequest;
import com.winter.model.manage.dimTourBasArea.DimTourBasArea;
import com.winter.model.manage.odsParkOptRent.OdsParkOptRent;
import com.winter.service.manage.dimTourBasArea.DimTourBasAreaService;
import com.winter.service.manage.odsParkOptRent.OdsParkOptRentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class OdsParkOptRentCompoent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OdsParkOptRentService odsParkOptRentService;

    @Autowired
    private DimTourBasAreaService dimTourBasAreaService;

    private static final String IP = "http://222.66.163.38:7001";
    private static final String API_FEE = "/dataSourceTest/getFinanceStatisticVO";//费用统计接口
    private static final String API_RENT = "/dataSourceTest/getBusinessStatisticVO";//building信息
    private static final String API_BUILDING = "/dataSourceTest/getCampusBuildingVOList";//楼宇列表

    private static final String AREAID = "30fe9d0f506849349e6b20f685b69dfb";
    private static final String BUILDINGID = "all";
    //"buildingName": "1号楼",
    private static final String AREAID_1 ="cd50516b8c354f9e91e72dc0329f178a";
    private static final String BUILDINGID_1 = "4dfb86c81c8b45a1841fd1d31e4a281c";

    //"buildingName": "2号楼",
    private static final String AREAID_2 = "4f9455e1b391492985872318f0f4836b";
    private static final String BUILDINGID_2 = "22ed016e24794fb28801d41724278e2e";

    //"buildingName": "3号楼",
    private static final String AREAID_3 = "e12c3a5960f74e28af48bbf0d13d289c";
    private static final String BUILDINGID_3 = "195e3529438e4b7c90aa2fd499c1e585";

    //"buildingName": "4号楼",
    private static final String AREAID_4 = "7d96131256d1445c992a507744c4cfcb";
    private static final String BUILDINGID_4 = "b3e43f719e8d4b239d1fbfc2f29a6eba";

    //"buildingName": "5号楼",
    private static final String AREAID_5 = "f7d032d202094f84b458cadf76faac04";
    private static final String BUILDINGID_5 = "b461f7a61a5e4b618d9213bb6fa6756d";

    //"buildingName": "6号楼",
    private static final String AREAID_6 = "8b93cda50cc84c858b51d9b258259aca";
    private static final String BUILDINGID_6 = "625664cdd10849d6820dd8002ef4437d";

    //"buildingName": "7号楼",
    private static final String AREAID_7 = "8b504c3560fc4ce2ba4b0ab040276738";
    private static final String BUILDINGID_7 = "";

    //"buildingName": "8号楼",
    private static final String AREAID_8 = "987fa7af1fef46ba84adfa398abfec89";
    private static final String BUILDINGID_8 = "";

    //"buildingName": "9号楼",
    private static final String AREAID_9 = "66f1bd94b9804c9fa532ef26a2ec3dda";
    private static final String BUILDINGID_9 = "";

//    @Scheduled(fixedRate=30000)
    public void requestBuildingList(){
        String url = IP + API_BUILDING;
        String res =  HttpRequest.doGet(url);
        if(res!=null){
            System.out.println(res);
            JSONObject resJson = JSON.parseObject(res);
            if(resJson.getString("code").equals("200")){
                System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇列表成功");
                JSONArray lists = resJson.getJSONArray("data");
                if(lists!=null&&!lists.isEmpty()){
                    System.out.println("楼宇信息：>>>>>>>>>>>>>>>有楼宇列表数据>>开始解析数据");
                    for(int i=0;i<lists.size();i++){
                        String buildingName = lists.getJSONObject(i).getString("buildingName");
                        String buildingId = lists.getJSONObject(i).getString("buildingId");
                        System.out.println("楼宇信息：>>>>>>>>>>>>>>>buildingName:"+buildingName+">>buildingId:"+buildingId);
                        requestRent(buildingId);
                        requestFee(buildingId);
                    }
                }else{
                    System.out.println("楼宇信息：>>>>>>>>>>>>>>>无楼宇列表数据");
                }
            }else{
                System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇列表失败>>500");
            }
        }else{
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇列表失败");
        }
        requestRent (BUILDINGID);
        requestFee(BUILDINGID);
    }
    public void requestRent(String buildingId){
//        String url = IP + API_RENT;
//        String param = "{" +
//                "\"campusId\":\"\","+
//                "\"buildingId\":\"" +buildingId+"\""+
//                "}";
//        String res =  HttpRequest.doPost(url,param);
        String url = IP + API_RENT;
        if(!buildingId.equals(BUILDINGID)){
            url = url +"?buildingId="+buildingId;
        }
        String res =  HttpRequest.doGet(url);
        if(res!=null){
            System.out.println(res);
            JSONObject resJson = JSON.parseObject(res);
            if(resJson.getString("code").equals("200")){
                System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇信息成功");
                JSONObject data = resJson.getJSONObject("data");
                if(data!=null){
                    System.out.println("楼宇信息：>>>>>>>>>>>>>>>有楼宇信息数据>>开始解析数据");
                    BigDecimal totalArea = data.getBigDecimal("totalArea");//总面积
                    BigDecimal investmentArea = data.getBigDecimal("investmentArea");//可招商面积
                    BigDecimal leasedArea = data.getBigDecimal("leasedArea");//已出租面积
                    BigDecimal vacantArea = data.getBigDecimal("vacantArea");//空置面积
                    BigDecimal tenantArea = data.getBigDecimal("tenantArea");//可租面积
                    BigDecimal matchingArea = data.getBigDecimal("matchingArea");//配套面积
                    Integer entepriseNum = data.getInteger("entepriseNum");//客户总数
                    System.out.println("楼宇信息: >>>>>>>>>>>>>>>总面积    :"+totalArea);
                    System.out.println("         >>>>>>>>>>>>>>>可招商面积:"+investmentArea);
                    System.out.println("         >>>>>>>>>>>>>>>已出租面积:"+leasedArea);
                    System.out.println("         >>>>>>>>>>>>>>>空置面积  :"+vacantArea);
                    System.out.println("         >>>>>>>>>>>>>>>可租面积  :"+tenantArea);
                    System.out.println("         >>>>>>>>>>>>>>>配套面积  :"+matchingArea);
                    System.out.println("         >>>>>>>>>>>>>>>客户总数  :"+entepriseNum);
                    DimTourBasArea dimTourBasArea = new DimTourBasArea();
                    dimTourBasArea.setTotalArea(totalArea);
                    dimTourBasArea.setInvitingArea(investmentArea);
                    dimTourBasArea.setRentArea(leasedArea);
                    dimTourBasArea.setVacancyArea(vacantArea);
                    dimTourBasArea.setCanRentArea(tenantArea);
                    dimTourBasArea.setSupportingArea(matchingArea);
                    dimTourBasArea.setEntepriseNum(entepriseNum);
                    dimTourBasArea.setUpdateTime(new Date());
                    updateDimTourBasArea(buildingId,dimTourBasArea);
                }else{
                    System.out.println("楼宇信息：>>>>>>>>>>>>>>>无楼宇信息数据");
                }
            }else{
                System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇信息失败>>500");
            }
        }else{
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇信息失败");
        }
    }
    public void requestFee(String buildingId){
//        String url = IP + API_FEE;
//        String param = "{" +
//                "\"campusId\":\"\","+
//                "\"buildingId\":\"" +buildingId+"\""+
//                "}";
//        String res =  HttpRequest.doPost(url,param);
        String url = IP + API_FEE;
        if(!buildingId.equals(BUILDINGID)){
            url = url +"?buildingId="+buildingId;
        }
        String res =  HttpRequest.doGet(url);
        if(res!=null){
            System.out.println(res);
            JSONObject resJson = JSON.parseObject(res);
            if(resJson.getString("code").equals("200")){
                System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇费用数据成功");
                JSONObject data = resJson.getJSONObject("data");
                if(data!=null){
                    System.out.println("楼宇信息：>>>>>>>>>>>>>>>有楼宇费用数据>>开始解析数据");
                    BigDecimal monthReceivedMoney = data.getBigDecimal("monthReceivedMoney");//当月已收租金
                    BigDecimal monthUnReceiveMoney = data.getBigDecimal("monthUnReceiveMoney");//当月未收租金
                    BigDecimal yearReceiveMoney = data.getBigDecimal("yearReceiveMoney");//当年已收租金合计
                    System.out.println("楼宇信息: >>>>>>>>>>>>>>>当月已收租金    :"+monthReceivedMoney);
                    System.out.println("         >>>>>>>>>>>>>>>当月未收租金    :"+monthUnReceiveMoney);
                    System.out.println("         >>>>>>>>>>>>>>>当年已收租金合计:"+yearReceiveMoney);
                    OdsParkOptRent odsParkOptRent = new OdsParkOptRent();
                    odsParkOptRent.setMonthReceivedMoney(monthReceivedMoney);
                    odsParkOptRent.setMonthUnReceiveMoney(monthUnReceiveMoney);
                    odsParkOptRent.setYearReceiveMoney(yearReceiveMoney);
                    odsParkOptRent.setCreateDate(new Date());
                    updateOdsParkOptRent(buildingId,odsParkOptRent);
                }else{
                    System.out.println("楼宇信息：>>>>>>>>>>>>>>>无楼宇费用数据");
                }
            }else{
                System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇费用数据失败>>500");
            }
        }else{
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>获取楼宇费用数据失败");
        }
    }
     private void updateOdsParkOptRent(String buildingId ,OdsParkOptRent o){
        if(buildingId.equals(BUILDINGID_1)){
            o.setAreaId(AREAID_1);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>1>>"+AREAID_1);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_2)){
            o.setAreaId(AREAID_2);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>2>>"+AREAID_2);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_3)){
            o.setAreaId(AREAID_3);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>3>>"+AREAID_3);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_4)){
            o.setAreaId(AREAID_4);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>4>>"+AREAID_4);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_5)){
            o.setAreaId(AREAID_5);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>5>>"+AREAID_5);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_6)){
            o.setAreaId(AREAID_6);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>6>>"+AREAID_6);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_7)){
            o.setAreaId(AREAID_7);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>7>>"+AREAID_7);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_8)){
            o.setAreaId(AREAID_8);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>8>>"+AREAID_8);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID_9)){
            o.setAreaId(AREAID_9);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>9>>"+AREAID_9);
            odsParkOptRentService.update(o);
        }else if(buildingId.equals(BUILDINGID)){
            o.setAreaId(AREAID);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新租金列表>>未来科技城>>"+AREAID);
            odsParkOptRentService.update(o);
        }else{
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>请求楼层与本地数据的区域未对应");
        }
     }
    private void updateDimTourBasArea(String buildingId ,DimTourBasArea o){
        if(buildingId.equals(BUILDINGID_1)){
            o.setId(AREAID_1);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>1>>"+AREAID_1);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_2)){
            o.setId(AREAID_2);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>2>>"+AREAID_2);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_3)){
            o.setId(AREAID_3);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>3>>"+AREAID_3);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_4)){
            o.setId(AREAID_4);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>4>>"+AREAID_4);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_5)){
            o.setId(AREAID_5);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>5>>"+AREAID_5);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_6)){
            o.setId(AREAID_6);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>6>>"+AREAID_6);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_7)){
            o.setId(AREAID_7);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>7>>"+AREAID_7);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_8)){
            o.setId(AREAID_8);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>8>>"+AREAID_8);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID_9)){
            o.setId(AREAID_9);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>9>>"+AREAID_9);
            dimTourBasAreaService.update(o);
        }else if(buildingId.equals(BUILDINGID)){
            o.setId(AREAID);
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>更新楼宇列表>>未来科技城>>"+AREAID);
            dimTourBasAreaService.update(o);
        }else{
            System.out.println("楼宇信息：>>>>>>>>>>>>>>>请求楼层与本地数据的区域未对应");
        }
    }
}
