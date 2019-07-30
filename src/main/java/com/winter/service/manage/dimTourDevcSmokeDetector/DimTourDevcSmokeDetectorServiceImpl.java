package com.winter.service.manage.dimTourDevcSmokeDetector;

import com.winter.mapper.manage.dimTourDevcSmokeDetector.DimTourDevcSmokeDetectorDao;
import com.winter.model.manage.dimTourDevcSmokeDetector.DimTourDevcSmokeDetector;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourDevcSmokeDetectorService")
public class DimTourDevcSmokeDetectorServiceImpl extends BaseServiceImp<DimTourDevcSmokeDetector> implements DimTourDevcSmokeDetectorService {

	@Autowired
	private DimTourDevcSmokeDetectorDao dimTourDevcSmokeDetectorDao;
}
