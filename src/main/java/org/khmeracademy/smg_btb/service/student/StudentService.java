package org.khmeracademy.smg_btb.service.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.student.Student;

public interface StudentService {


	public ArrayList<Student> findAll();
	public void save(Student student);
	public void updateStatus(int id);
	public void updateById(Student student);
}
