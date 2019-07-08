package com.winter.service.manage.dimTourDevcSensor;

import com.winter.mapper.manage.dimTourDevcSensor.DimTourDevcSensorDao;
import com.winter.model.manage.dimTourDevcSensor.DimTourDevcSensor;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourDevcSensorService")
public class DimTourDevcSensorServiceImpl extends BaseServiceImp<DimTourDevcSensor> implements DimTourDevcSensorService {

	@Autowired
	private DimTourDevcSensorDao dimTourDevcSensorDao;
}
