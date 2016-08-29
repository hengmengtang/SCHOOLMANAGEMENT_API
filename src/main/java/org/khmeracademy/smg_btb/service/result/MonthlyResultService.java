package org.khmeracademy.smg_btb.service.result;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.monthly_result.ParamViewResult;
import org.khmeracademy.smg_btb.entity.form.monthly_result.ResultStudentEachMonth;
import org.khmeracademy.smg_btb.entity.form.monthly_result.Subject;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;
import org.khmeracademy.smg_btb.entity.form.view_score.ParamViewScore;

public interface MonthlyResultService {

	public ArrayList<SubjectBasic> resultBasic(ParamViewScore viewScore);
	public ArrayList<SubjectAdvance> resultAdvance(ParamViewScore viewScore);
	public ArrayList<Subject.basic> resultBasicOnMonth(ParamViewResult result);
	public ArrayList<ResultStudentEachMonth> studentResultEachMonth(String student_name);
	public ArrayList<ResultStudentEachMonth> getMonth(String student_name);
}
