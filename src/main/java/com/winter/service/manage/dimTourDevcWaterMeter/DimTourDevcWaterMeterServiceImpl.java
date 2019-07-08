package com.winter.service.manage.dimTourDevcWaterMeter;

import com.winter.mapper.manage.dimTourDevcWaterMeter.DimTourDevcWaterMeterDao;
import com.winter.model.manage.dimTourDevcWaterMeter.DimTourDevcWaterMeter;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourDevcWaterMeterService")
public class DimTourDevcWaterMeterServiceImpl extends BaseServiceImp<DimTourDevcWaterMeter> implements DimTourDevcWaterMeterService {

	@Autowired
	private DimTourDevcWaterMeterDao dimTourDevcWaterMeterDao;
}
