package com.winter.service.manage.dimTourBas3dRoom;

import com.winter.mapper.manage.dimTourBas3dRoom.DimTourBas3dRoomDao;
import com.winter.model.manage.dimTourBas3dRoom.DimTourBas3dRoom;
import com.winter.service.baseService.impl.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("DimTourBas3dRoomService")
public class DimTourBas3dRoomServiceImpl extends BaseServiceImp<DimTourBas3dRoom> implements DimTourBas3dRoomService {

	@Autowired
	private DimTourBas3dRoomDao dimTourBas3dRoomDao;
}
