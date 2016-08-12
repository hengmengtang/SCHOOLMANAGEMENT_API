package org.khmeracademy.smg_btb.service.enrollment;

import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;

public interface EnrollmentService {
	
	/*public ArrayList<Enrollment> findAll();*/
	public int enrollStudent(Enrollment.EnrollmentStudent enrollmentStudent);
	/*public boolean changeStatus(CloseCourse closeGeneration);*/
}
