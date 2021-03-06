package org.khmeracademy.smg_btb.service.impl.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.checkUser.CheckUser;
import org.khmeracademy.smg_btb.entity.form.display_student_to_enroll.DisplayStudentToEnroll;
import org.khmeracademy.smg_btb.entity.form.display_student_to_enroll.ParamDisplayStudent;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.entity.student.Student.subStudent;
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
	public ArrayList<Student.subStudent> select_student_by_generation_course(Student.getCourseByStaffGenerationCourse getGenerationCourse) {
		return studentRepository.select_student_by_generation_course(getGenerationCourse);
	}

	@Override
	public Student selectStudentById(String stu_id) {
		return studentRepository.selectStudentById(stu_id);
	}

	@Override
	public ArrayList<subStudent> getStudentByGeneration(String generation_name) {
		return studentRepository.getStudentByGeneration(generation_name);
	}

	@Override
	public ArrayList<DisplayStudentToEnroll> displayStudentToEnroll(ParamDisplayStudent param) {
		return studentRepository.displayStudentToEnroll(param);
	}

	@Override
	public ArrayList<subStudent> getStudentByClass(String class_name) {
		return studentRepository.getStudentByClass(class_name);
	}

	@Override
	public ArrayList<subStudent> getStudentInLastGeneration() {
		return studentRepository.getStudentInLastGeneration();
	}
	
	@Override
	public ArrayList<DisplayStudentToEnroll> displayStudentNotYetEnroll() {
		return studentRepository.displayStudentNotYetEnroll();
	}

	@Override
	public ArrayList<DisplayStudentToEnroll> displayStudentEnrollAlready() {
		return studentRepository.displayStudentEnrollAlready();
	}

	@Override
	public ArrayList<DisplayStudentToEnroll> studentInBasic(String generation_name) {
		return studentRepository.studentInBasic(generation_name);
	}
}
