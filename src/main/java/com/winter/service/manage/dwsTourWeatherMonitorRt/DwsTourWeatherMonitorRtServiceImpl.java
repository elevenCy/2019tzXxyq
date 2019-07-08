package com.winter.service.manage.dwsTourWeatherMonitorRt;

import com.winter.mapper.manage.dwsTourWeatherMonitorRt.DwsTourWeatherMonitorRtDao;
import com.winter.model.manage.dwsTourWeatherMonitorRt.DwsTourWeatherMonitorRt;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DwsTourWeatherMonitorRtService")
public class DwsTourWeatherMonitorRtServiceImpl extends BaseServiceImp<DwsTourWeatherMonitorRt> implements DwsTourWeatherMonitorRtService {

	@Autowired
	private DwsTourWeatherMonitorRtDao dwsTourWeatherMonitorRtDao;
}
