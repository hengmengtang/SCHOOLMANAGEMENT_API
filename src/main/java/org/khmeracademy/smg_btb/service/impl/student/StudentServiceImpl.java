package org.khmeracademy.smg_btb.service.impl.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.checkUser.CheckUser;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.entity.student.Student.MaxId;
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
	public boolean save(Student student) {
		
		 return studentRepository.save(student);
	}

	@Override
	public boolean updateStatus(String id) {
		return studentRepository.updateStatus(id);
	}

	@Override
	public boolean updateById(Student student) {
		return studentRepository.updateById(student);
	}

	@Override
	public CheckUser checkUser(CheckUser checkUser) {	
		return studentRepository.checkUser(checkUser);
	}

	@Override
	public MaxId selectMaxId() {
		return studentRepository.selectMax();
	}

	@Override
	public ArrayList<Student> select_student_by_generation_course() {
		return studentRepository.select_student_by_generation_course();
	}
}
