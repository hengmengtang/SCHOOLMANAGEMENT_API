package org.khmeracademy.smg_btb.service.impl.result;

import java.util.ArrayList;

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

}
