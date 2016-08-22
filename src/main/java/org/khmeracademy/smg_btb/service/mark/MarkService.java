package org.khmeracademy.smg_btb.service.mark;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.add_mark.DisplayAddMark;
import org.khmeracademy.smg_btb.entity.form.mark.ParamUpdateScore;
import org.khmeracademy.smg_btb.entity.mark.Mark;

public interface MarkService {

	public int addMark(Mark mark);
	public ArrayList<DisplayAddMark> displayStudentToAddScore();
	public boolean update(ParamUpdateScore updateScore);
}
