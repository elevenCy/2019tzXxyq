package com.winter.service.manage.dimTourDevcVideoSurveillance;

import com.winter.mapper.manage.dimTourDevcVideoSurveillance.DimTourDevcVideoSurveillanceDao;
import com.winter.model.manage.dimTourDevcVideoSurveillance.DimTourDevcVideoSurveillance;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourDevcVideoSurveillanceService")
public class DimTourDevcVideoSurveillanceServiceImpl extends BaseServiceImp<DimTourDevcVideoSurveillance> implements DimTourDevcVideoSurveillanceService {

	@Autowired
	private DimTourDevcVideoSurveillanceDao dimTourDevcVideoSurveillanceDao;
}
