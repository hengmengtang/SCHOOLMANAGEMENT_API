package org.khmeracademy.smg_btb.service.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.checkUser.CheckUser;
import org.khmeracademy.smg_btb.entity.form.display_student_to_enroll.DisplayStudentToEnroll;
import org.khmeracademy.smg_btb.entity.form.display_student_to_enroll.ParamDisplayStudent;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;

public interface StudentService {


	public ArrayList<Student> findAll();
	public boolean save(Student student);
	public boolean updateStatus(String id);
	public boolean updateById(Student student);
	public CheckUser checkUser(CheckUser checkUser);
	public MaxId selectMaxId();
	public ArrayList<Student.subStudent> select_student_by_generation_course(Student.getGenerationCourse getGenerationCourse);
	public Student selectStudentById(String stu_id);
	public ArrayList<Student.subStudent> getStudentByGeneration(String generation_name);
	public ArrayList<DisplayStudentToEnroll> displayStudentToEnroll(ParamDisplayStudent param);
	public ArrayList<Student.subStudent> getStudentByClass(String class_name);
	public ArrayList<Student.subStudent> getStudentInLastGeneration();
}
