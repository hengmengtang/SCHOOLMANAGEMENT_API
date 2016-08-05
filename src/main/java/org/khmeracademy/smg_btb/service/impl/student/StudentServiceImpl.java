package org.khmeracademy.smg_btb.service.impl.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.repository.student.StudentRepository;
import org.khmeracademy.smg_btb.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public ArrayList<Student> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public void save(Student student) {
		
		 studentRepository.save(student);
	}

	@Override
	public void updateStatus(int id) {
		studentRepository.updateStatus(id);
	}

	@Override
	public void updateById(Student student) {
		studentRepository.updateById(student);
	}
}
