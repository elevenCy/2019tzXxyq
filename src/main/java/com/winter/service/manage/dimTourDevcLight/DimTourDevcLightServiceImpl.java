package com.winter.service.manage.dimTourDevcLight;

import com.winter.mapper.manage.dimTourDevcLight.DimTourDevcLightDao;
import com.winter.model.manage.dimTourDevcLight.DimTourDevcLight;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DimTourDevcLightService")
public class DimTourDevcLightServiceImpl extends BaseServiceImp<DimTourDevcLight> implements DimTourDevcLightService {

	@Autowired
	private DimTourDevcLightDao dimTourDevcLightDao;
}
