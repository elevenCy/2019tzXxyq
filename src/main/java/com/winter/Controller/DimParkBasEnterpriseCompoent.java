package com.winter.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winter.common.HttpRequest;
import com.winter.model.manage.dimParkBasAgreement.DimParkBasAgreement;
import com.winter.model.manage.dimParkBasEnterprise.DimParkBasEnterprise;
import com.winter.model.manage.dimTourBas3dRoom.DimTourBas3dRoom;
import com.winter.service.manage.dimParkBasAgreement.DimParkBasAgreementService;
import com.winter.service.manage.dimParkBasEnterprise.DimParkBasEnterpriseService;
import com.winter.service.manage.dimTourBas3dRoom.DimTourBas3dRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by h on 2018/12/6.
 */
//@RestController//请求
@Component
public class DimParkBasEnterpriseCompoent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DimParkBasAgreementService dimParkBasAgreementService;

    @Autowired
    private DimParkBasEnterpriseService dimParkBasEnterpriseService;

    @Autowired
    private DimTourBas3dRoomService dimTourBas3dRoomService;

    private static final String API = "http://222.66.124.34:8082/tujingData/getEnterprise";
//    @Scheduled(fixedRate=5000)
    public void requestList(){
        String res = HttpRequest.doPost(API,"");
        if(res!=null&&!res.equals("")){
            System.out.println(res);
            JSONObject resJson = null;
            JSONArray jsonArr = new JSONArray();
            resJson = JSON.parseObject(res);
            DimParkBasEnterprise dimParkBasEnterprise = new DimParkBasEnterprise();
            List<DimParkBasEnterprise> os = dimParkBasEnterpriseService.find(dimParkBasEnterprise);
            if(os!=null&&os.isEmpty()){//对比最新获取到企业和本地库中有的企业  若本地库中没有最新的有效企业则将本地库中该企业的协议置为删除状态本清空该企业所占据的所有房间
                for(DimParkBasEnterprise o:os){
                    JSONObject exist = null;
                    for(int i=0;i<jsonArr.size();i++){
                        JSONObject jsonObj = jsonArr.getJSONObject(i);
                        if(o.getId().equals(jsonObj.getString("id"))){
                            exist = jsonObj;
                        }
                    }
                    if(exist!=null){//本地库中的这一条数据在最新的有效数据中存在

                    }else{//本地库中的这一条数据在最新的有效数据中不存在
                        //查找有关该企业的所有协议
                        DimParkBasAgreement dimParkBasAgreement = new DimParkBasAgreement();
                        dimParkBasAgreement.setEnterpriseId(o.getId());
                        List<DimParkBasAgreement> dimParkBasAgreements = dimParkBasAgreementService.find(dimParkBasAgreement);
                        if(dimParkBasAgreements!=null&&!dimParkBasAgreements.isEmpty()){//若有协议
                            System.out.println(o.getName()+"删除该企业所有协议！！！");//删除该协议
                            for(DimParkBasAgreement item:dimParkBasAgreements){
                                dimParkBasAgreementService.delete(item);
                            }
                        }else{//没有协议
                            System.out.println(o.getName()+"该企业没有协议！！！");
                        }
                        DimTourBas3dRoom dimTourBas3dRoom = new DimTourBas3dRoom();
                        dimTourBas3dRoom.setEnterpriseId(o.getId());
                        List<DimTourBas3dRoom> dimTourBas3dRooms  = dimTourBas3dRoomService.find(dimTourBas3dRoom);
                        if(dimTourBas3dRooms!=null&&!dimTourBas3dRooms.isEmpty()){
                            System.out.println(o.getName()+"该企业所入住的房间全部清空！！！");//删除该协议
                            for(DimTourBas3dRoom item:dimTourBas3dRooms){
                                item.setEnterpriseId("");
                                dimTourBas3dRoomService.update(item);
                            }
                        }else{
                            System.out.println(o.getName()+"该企业没有入住房间！！！");
                        }
                    }
                }
            }else{//将所有的企业插入数据表
                System.out.println("本地数据库中没有企业数据！！！");
            }
        }else{
            System.out.println("企业信息请求失败！！！");
        }
    }
}
