package com.winter.service.manage.dimTourDevcEntranceGuard;

import com.winter.mapper.manage.dimTourDevcEntranceGuard.DimTourDevcEntranceGuardDao;
import com.winter.model.manage.dimTourDevcEntranceGuard.DimTourDevcEntranceGuard;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourDevcEntranceGuardService")
public class DimTourDevcEntranceGuardServiceImpl extends BaseServiceImp<DimTourDevcEntranceGuard> implements DimTourDevcEntranceGuardService {

	@Autowired
	private DimTourDevcEntranceGuardDao dimTourDevcEntranceGuardDao;

}
