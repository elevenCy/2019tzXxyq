package com.winter.service.manage.dwdParkOptDevcEventInfo;

import com.winter.mapper.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfoDao;
import com.winter.model.manage.dwdParkOptDevcEventInfo.DwdParkOptDevcEventInfo;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DwdParkOptDevcEventInfoService")
public class DwdParkOptDevcEventInfoServiceImpl extends BaseServiceImp<DwdParkOptDevcEventInfo> implements DwdParkOptDevcEventInfoService {

	@Autowired
	private DwdParkOptDevcEventInfoDao dwdParkOptDevcEventInfoDao;
}
