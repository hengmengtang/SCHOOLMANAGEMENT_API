package org.khmeracademy.smg_btb.service.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.checkUser.CheckUser;
import org.khmeracademy.smg_btb.entity.student.Student;

public interface StudentService {


	public ArrayList<Student> findAll();
	public boolean save(Student student);
	public boolean updateStatus(int id);
	public boolean updateById(Student student);
	public CheckUser checkUser(String eng_full_name,String phone);
	public String selectMax();
}
