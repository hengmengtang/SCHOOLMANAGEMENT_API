package org.khmeracademy.smg_btb.service.result;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;

public interface MonthlyResultService {

	public ArrayList<SubjectBasic> resultBasic(String generation_name);
	public ArrayList<SubjectAdvance> resultAdvance(String generation_name);
}
