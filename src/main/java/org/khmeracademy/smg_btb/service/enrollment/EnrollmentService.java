package org.khmeracademy.smg_btb.service.enrollment;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;
import org.khmeracademy.smg_btb.entity.form.close_course.CloseCourse;

public interface EnrollmentService {
	
	public ArrayList<Enrollment> findAll();
	public boolean insert(Enrollment enrollment);
	public boolean changeStatus(CloseCourse closeGeneration);
}
