package org.khmeracademy.smg_btb.service.enrollment;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;

public interface EnrollmentService {
	
	public ArrayList<Enrollment> findAll();
	public boolean insert(Enrollment enrollment);
}
