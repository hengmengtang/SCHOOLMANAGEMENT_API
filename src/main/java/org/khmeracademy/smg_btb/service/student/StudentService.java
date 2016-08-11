package org.khmeracademy.smg_btb.service.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.checkUser.CheckUser;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.entity.student.Student.MaxId;

public interface StudentService {


	public ArrayList<Student> findAll();
	public boolean save(Student student);
	public boolean updateStatus(String id);
	public boolean updateById(Student student);
	public CheckUser checkUser(CheckUser checkUser);
	public MaxId selectMaxId();
	public ArrayList<Student> select_student_by_generation_course();
}
