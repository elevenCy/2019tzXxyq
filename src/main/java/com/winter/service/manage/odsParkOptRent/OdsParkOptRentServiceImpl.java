package com.winter.service.manage.odsParkOptRent;

import com.winter.mapper.manage.odsParkOptRent.OdsParkOptRentDao;
import com.winter.model.manage.odsParkOptRent.OdsParkOptRent;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("OdsParkOptRentService")
public class OdsParkOptRentServiceImpl extends BaseServiceImp<OdsParkOptRent> implements OdsParkOptRentService {

	@Autowired
	private OdsParkOptRentDao odsParkOptRentDao;
}
