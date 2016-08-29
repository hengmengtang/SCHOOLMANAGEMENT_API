package org.khmeracademy.smg_btb.service.impl.result;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.monthly_result.ParamViewResult;
import org.khmeracademy.smg_btb.entity.form.monthly_result.ResultStudentEachMonth;
import org.khmeracademy.smg_btb.entity.form.monthly_result.Subject.basic;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;
import org.khmeracademy.smg_btb.entity.form.view_score.ParamViewScore;
import org.khmeracademy.smg_btb.repository.result.ResultRepository;
import org.khmeracademy.smg_btb.service.result.MonthlyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthlyResultServiceImpl implements MonthlyResultService {

	@Autowired
	ResultRepository resultRepository;
	
	@Override
	public ArrayList<SubjectBasic> resultBasic(ParamViewScore viewScore) {
		return resultRepository.resultBasic(viewScore);
	}

	@Override
	public ArrayList<SubjectAdvance> resultAdvance(ParamViewScore viewScore) {
		return resultRepository.resultAdvance(viewScore);
	}

	@Override
	public ArrayList<basic> resultBasicOnMonth(ParamViewResult result) {
		return resultRepository.resultBasicOnMonth(result);
	}

	@Override
	public ArrayList<ResultStudentEachMonth> studentResultEachMonth(String student_name) {
		return resultRepository.studentResultEachMonth(student_name);
	}

	@Override
	public ArrayList<ResultStudentEachMonth> getMonth(String student_name) {
		return resultRepository.getMonth(student_name);
	}

}
