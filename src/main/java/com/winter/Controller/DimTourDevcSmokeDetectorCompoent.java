package com.winter.Controller;

import com.winter.model.manage.dimTourDevcSmokeDetector.DimTourDevcSmokeDetector;
import com.winter.service.manage.dimTourDevcSmokeDetector.DimTourDevcSmokeDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DimTourDevcSmokeDetectorCompoent {
    @Autowired
    private DimTourDevcSmokeDetectorService dimTourDevcSmokeDetectorService;
    //烟感点位 5*60
    @Scheduled(fixedRate=300000)
    public void requestList(){
        System.out.println("查询锐志数据库中的烟感设备数据并匹配好状态位");
        String sql = "select t.FDEVICE_UUID as id,t.FDEVICE_NAME as name,t.FPOSITION as address," +
                "   CASE a.TYPE" +
                "       WHEN 'G4436' THEN 0" +
                "       ELSE 1" +
                "   END as status,a.TYPE as remark" +
                " from rz_protection_data t" +
                //G4437在线G4436离线
                " left join (" +
                "   select FDEVICE_UUID,substring_index(GROUP_CONCAT(`TYPE` ORDER BY FCOME_TIME desc),',',1) as TYPE from rz_protection_error" +
                "   GROUP BY FDEVICE_UUID) a on t.FDEVICE_UUID = a.FDEVICE_UUID";
        List<DimTourDevcSmokeDetector> rzList = dimTourDevcSmokeDetectorService.findBySql(sql);
        if(rzList!=null&&!rzList.isEmpty()){
            System.out.println("查询锐志数据库中的烟感设备数据并匹配好状态位>>成功");
            for(DimTourDevcSmokeDetector rzDimTourDevcSmokeDetector:rzList){
                DimTourDevcSmokeDetector myDimTourDevcSmokeDetector = new DimTourDevcSmokeDetector();
                myDimTourDevcSmokeDetector.setId(rzDimTourDevcSmokeDetector.getId());
                System.out.println("对比本地库数据>>"+rzDimTourDevcSmokeDetector.getName());
                List<DimTourDevcSmokeDetector> myList = dimTourDevcSmokeDetectorService.find(myDimTourDevcSmokeDetector);
                Date now = new Date();
                if(myList!=null&&!myList.isEmpty()){
                    myDimTourDevcSmokeDetector = myList.get(0);
                    System.out.println("更新本地库数据>>"+myDimTourDevcSmokeDetector.getName());
                    myDimTourDevcSmokeDetector.setName(rzDimTourDevcSmokeDetector.getName());
                    myDimTourDevcSmokeDetector.setAddress(rzDimTourDevcSmokeDetector.getAddress());
                    myDimTourDevcSmokeDetector.setStatus(rzDimTourDevcSmokeDetector.getStatus());
                    myDimTourDevcSmokeDetector.setUpdateTime(now);
                    myDimTourDevcSmokeDetector.setRemark(rzDimTourDevcSmokeDetector.getRemark());
                    dimTourDevcSmokeDetectorService.update(myDimTourDevcSmokeDetector);
                }else{
                    System.out.println("添加本地库数据>>"+rzDimTourDevcSmokeDetector.getName());
                    rzDimTourDevcSmokeDetector.setSort(1);
                    rzDimTourDevcSmokeDetector.setCreateTime(now);
                    rzDimTourDevcSmokeDetector.setUpdateTime(now);
                    dimTourDevcSmokeDetectorService.insert(rzDimTourDevcSmokeDetector);
                }
            }
        }else{
            System.out.println("查询锐志数据库中的电表数据并匹配好状态位>>失败");
        }
    }
}
