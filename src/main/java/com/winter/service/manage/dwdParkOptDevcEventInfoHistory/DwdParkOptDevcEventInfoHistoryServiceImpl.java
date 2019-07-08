package com.winter.service.manage.dwdParkOptDevcEventInfoHistory;

import com.winter.mapper.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistoryDao;
import com.winter.model.manage.dwdParkOptDevcEventInfoHistory.DwdParkOptDevcEventInfoHistory;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DwdParkOptDevcEventInfoHistoryService")
public class DwdParkOptDevcEventInfoHistoryServiceImpl extends BaseServiceImp<DwdParkOptDevcEventInfoHistory> implements DwdParkOptDevcEventInfoHistoryService {

	@Autowired
	private DwdParkOptDevcEventInfoHistoryDao dwdParkOptDevcEventInfoHistoryDao;
}
