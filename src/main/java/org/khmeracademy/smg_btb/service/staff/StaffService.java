package org.khmeracademy.smg_btb.service.staff;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.compareHandleSubjectToStaff;
import org.khmeracademy.smg_btb.entity.form.display_staff_in_class.StaffInClass;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.staff.Staff;

public interface StaffService {
 
	public ArrayList<Staff> findAll();
	public boolean save(Staff staff);
	public MaxId selectMax();
	public ArrayList<StaffInClass> getStaffInClass();
	public ArrayList<compareHandleSubjectToStaff> getListStaff();
}
