package org.khmeracademy.smg_btb.service.impl.enrollment;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;
import org.khmeracademy.smg_btb.repository.enrollment.EnrollmentRepository;
import org.khmeracademy.smg_btb.service.enrollment.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceEmpl implements EnrollmentService{

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Override
	public ArrayList<Enrollment> findAll() {
		return enrollmentRepository.findAll();
	}

	@Override
	public boolean insert(Enrollment enrollment) {		
		return enrollmentRepository.insert(enrollment);
	}

}
