package org.khmeracademy.smg_btb.service.impl.staff;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.compareHandleSubjectToStaff;
import org.khmeracademy.smg_btb.entity.form.display_staff_in_class.StaffInClass;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.staff.Staff;
import org.khmeracademy.smg_btb.repository.staff.StaffRepository;
import org.khmeracademy.smg_btb.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public ArrayList<Staff> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public boolean save(Staff staff) {
		return staffRepository.save(staff);
	}

	@Override
	public MaxId selectMax() {
		return staffRepository.selectMax();
	}

	@Override
	public ArrayList<StaffInClass> getStaffInClass() {
		return staffRepository.getStaffInClass();
	}

	@Override
	public ArrayList<compareHandleSubjectToStaff> getListStaff() {
		return staffRepository.getListStaff();
	}

}
