package org.khmeracademy.smg_btb.service.impl.enrollment;

import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;
import org.khmeracademy.smg_btb.repository.enrollment.EnrollmentRepository;
import org.khmeracademy.smg_btb.service.enrollment.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceEmpl implements EnrollmentService{

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	/*@Override
	public ArrayList<Enrollment> findAll() {
		return enrollmentRepository.findAll();
	}*/

	@Override
	public int enrollStudent(Enrollment.EnrollmentStudent enrollmentStudent) {		
		return enrollmentRepository.enrollStudent(enrollmentStudent);
	}
	
	/*@Override
	public boolean changeStatus(CloseCourse closeGeneration){
		return enrollmentRepository.changeStatus(closeGeneration);
	}*/

}
