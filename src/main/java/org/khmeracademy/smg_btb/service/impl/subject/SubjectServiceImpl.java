package org.khmeracademy.smg_btb.service.impl.subject;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.add_mark.ParamForGetSubject;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.subject.Subject;
import org.khmeracademy.smg_btb.repository.subject.SubjectRepository;
import org.khmeracademy.smg_btb.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public ArrayList<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	public boolean insert(Subject subject) {
		return subjectRepository.enrollSubject(subject);
	}

	@Override
	public MaxId selectMax() {
		return subjectRepository.selectMax();
	}
	
	@Override
	public ArrayList<Subject> getSubjectInCourse(ParamForGetSubject subject) {
		return subjectRepository.getSubjectInCourse(subject);
	}
}
