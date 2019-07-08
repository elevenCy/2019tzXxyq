package com.winter.service.manage.dimParkBasEnterprise;

import com.winter.mapper.manage.dimParkBasEnterprise.DimParkBasEnterpriseDao;
import com.winter.model.manage.dimParkBasEnterprise.DimParkBasEnterprise;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimParkBasEnterpriseService")
public class DimParkBasEnterpriseServiceImpl extends BaseServiceImp<DimParkBasEnterprise> implements DimParkBasEnterpriseService {

	@Autowired
	private DimParkBasEnterpriseDao dimParkBasEnterpriseDao;
}
