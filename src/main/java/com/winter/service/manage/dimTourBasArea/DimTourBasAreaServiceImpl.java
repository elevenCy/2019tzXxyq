package com.winter.service.manage.dimTourBasArea;

import com.winter.mapper.manage.dimTourBasArea.DimTourBasAreaDao;
import com.winter.model.manage.dimTourBasArea.DimTourBasArea;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourBasAreaService")
public class DimTourBasAreaServiceImpl extends BaseServiceImp<DimTourBasArea> implements DimTourBasAreaService {

	@Autowired
	private DimTourBasAreaDao dimTourBasAreaDao;
}
