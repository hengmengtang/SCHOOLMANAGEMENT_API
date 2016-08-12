package org.khmeracademy.smg_btb.service.impl.mark;

import org.khmeracademy.smg_btb.entity.mark.Mark;
import org.khmeracademy.smg_btb.repository.mark.MarkRepository;
import org.khmeracademy.smg_btb.service.mark.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkServiceImpl implements MarkService{

	@Autowired
	MarkRepository markRepository;
	
	@Override
	public int addMark(Mark mark) {
		return markRepository.addMark(mark);
	}

	
}
