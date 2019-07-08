package com.winter.service.manage.dimTourBas3dResource;

import com.winter.mapper.manage.dimTourBas3dResource.DimTourBas3dResourceDao;
import com.winter.model.manage.dimTourBas3dResource.DimTourBas3dResource;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourBas3dResourceService")
public class DimTourBas3dResourceServiceImpl extends BaseServiceImp<DimTourBas3dResource> implements DimTourBas3dResourceService {

	@Autowired
	private DimTourBas3dResourceDao dimTourBas3dResourceDao;
}
