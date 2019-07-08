package com.winter.service.manage.dimParkBasAgreement;

import com.winter.mapper.manage.dimParkBasAgreement.DimParkBasAgreementDao;
import com.winter.model.manage.dimParkBasAgreement.DimParkBasAgreement;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimParkBasAgreementService")
public class DimParkBasAgreementServiceImpl extends BaseServiceImp<DimParkBasAgreement> implements DimParkBasAgreementService {

	@Autowired
	private DimParkBasAgreementDao dimParkBasAgreementDao;
}
