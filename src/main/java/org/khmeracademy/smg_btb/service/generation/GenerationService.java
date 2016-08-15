package org.khmeracademy.smg_btb.service.generation;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.generation.Generation;

public interface GenerationService {
	
	public ArrayList<Generation> findAll();
	public boolean registerGeneration(Generation generation);
	public MaxId selectMax();
	public ArrayList<Generation> getLastGeneration();
	public boolean changeStatusTrue(String gen_id);
}
