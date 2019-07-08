package com.winter.service.manage.dimTourBasResource;

import com.winter.mapper.manage.dimTourBasResource.DimTourBasResourceDao;
import com.winter.model.manage.dimTourBasResource.DimTourBasResource;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourBasResourceService")
public class DimTourBasResourceServiceImpl extends BaseServiceImp<DimTourBasResource> implements DimTourBasResourceService {

	@Autowired
	private DimTourBasResourceDao dimTourBasResourceDao;
}
