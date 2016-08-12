package org.khmeracademy.smg_btb.service.impl.handle;

import org.khmeracademy.smg_btb.entity.handle.HandleSubjectToStaffToClassRoom;
import org.khmeracademy.smg_btb.repository.handle.HandleSubjectToStaffToClassRepository;
import org.khmeracademy.smg_btb.service.handle.HandleSubjectToStaffToClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleSubjectToStaffToClassServiceImpl implements HandleSubjectToStaffToClassService{

	
	@Autowired
	HandleSubjectToStaffToClassRepository handleRepository;
	
	@Override
	public int handleSubjectToStaffToClass(HandleSubjectToStaffToClassRoom handle) {
		return handleRepository.handleSubjectToStaffToClass(handle);
	}

}
