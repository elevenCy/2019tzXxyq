package com.winter.Controller;


import com.winter.model.manage.dimTourDevcAmmeter.DimTourDevcAmmeter;
import com.winter.service.manage.dimTourDevcAmmeter.DimTourDevcAmmeterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    //监控点位
    @Scheduled(fixedRate=420000)
    public void requestList(){
        System.out.println("查询锐志数据库中的电表数据并匹配好状态位");
        String sql = "select t.FPOWERDEV_UUID as id,t.FPOWERDEV_NAME as device_name,t.FPOSITION as remark," +
                        "   CASE a.TYPE" +
                        "       WHEN 'G4436' THEN 0" +
                        "       ELSE 1" +
                        "   END as status,a.TYPE as data_id" +
                    " from rz_electric_equipment t" +
                //G4437在线G4436离线
                    " left join (" +
                    "   select FPOWERDEV_UUID,substring_index(GROUP_CONCAT(`TYPE` ORDER BY FCOME_TIME desc),',',1) as TYPE from rz_electric_error" +
                    "   GROUP BY FPOWERDEV_UUID) a on t.FPOWERDEV_UUID = a.FPOWERDEV_UUID";
        List<DimTourDevcAmmeter> rzList = dimTourDevcAmmeterService.findBySql(sql);
        if(rzList!=null&&!rzList.isEmpty()){
            System.out.println("查询锐志数据库中的电表数据并匹配好状态位>>成功");
            for(DimTourDevcAmmeter rzDimTourDevcAmmeter:rzList){
                DimTourDevcAmmeter myDimTourDevcAmmeter = new DimTourDevcAmmeter();
                myDimTourDevcAmmeter.setId(rzDimTourDevcAmmeter.getId());
                System.out.println("对比本地库数据>>"+rzDimTourDevcAmmeter.getDeviceName());
                List<DimTourDevcAmmeter> myList = dimTourDevcAmmeterService.find(myDimTourDevcAmmeter);
                Date now = new Date();
                if(myList!=null&&!myList.isEmpty()){
                    myDimTourDevcAmmeter = myList.get(0);
                    System.out.println("更新本地库数据>>"+myDimTourDevcAmmeter.getDeviceName());
                    myDimTourDevcAmmeter.setDeviceName(rzDimTourDevcAmmeter.getDeviceName());
                    myDimTourDevcAmmeter.setRemark(rzDimTourDevcAmmeter.getRemark());
                    myDimTourDevcAmmeter.setStatus(rzDimTourDevcAmmeter.getStatus());
                    myDimTourDevcAmmeter.setDataId(rzDimTourDevcAmmeter.getDataId());
                    myDimTourDevcAmmeter.setUpdateTime(now);
                    dimTourDevcAmmeterService.update(myDimTourDevcAmmeter);
                }else{
                    System.out.println("添加本地库数据>>"+rzDimTourDevcAmmeter.getDeviceName());
                    rzDimTourDevcAmmeter.setCreateTime(now);
                    rzDimTourDevcAmmeter.setUpdateTime(now);
                    rzDimTourDevcAmmeter.setMeasId("0");
                    rzDimTourDevcAmmeter.setMeasName("0");
                    rzDimTourDevcAmmeter.setDeviceId(rzDimTourDevcAmmeter.getId());
                    rzDimTourDevcAmmeter.setChannelName("0");
                    rzDimTourDevcAmmeter.setValue("0");
                    rzDimTourDevcAmmeter.setSwitchValue("0");
                    dimTourDevcAmmeterService.insert(rzDimTourDevcAmmeter);
                }
            }
        }else{
            System.out.println("查询锐志数据库中的电表数据并匹配好状态位>>失败");
        }
    }
}
