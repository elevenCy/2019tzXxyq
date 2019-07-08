package com.winter.service.manage.dimTourDevcAmmeter;

import com.winter.mapper.manage.dimTourDevcAmmeter.DimTourDevcAmmeterDao;
import com.winter.model.manage.dimTourDevcAmmeter.DimTourDevcAmmeter;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourDevcAmmeterService")
public class DimTourDevcAmmeterServiceImpl extends BaseServiceImp<DimTourDevcAmmeter> implements DimTourDevcAmmeterService {

	@Autowired
	private DimTourDevcAmmeterDao dimTourDevcAmmeterDao;
}
