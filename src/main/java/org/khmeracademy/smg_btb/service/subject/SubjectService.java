package org.khmeracademy.smg_btb.service.subject;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.entity.subject.Subject;

public interface SubjectService {

	public ArrayList<Subject> findAll();
	public boolean insert(Subject subject);
	public MaxId selectMax();
	public ArrayList<Subject> getSubjectInCourse(Student.getGenerationCourse generationCourse);
}
