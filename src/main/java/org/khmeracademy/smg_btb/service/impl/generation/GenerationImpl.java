package org.khmeracademy.smg_btb.service.impl.generation;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.generation.Generation;
import org.khmeracademy.smg_btb.repository.generation.GenerationRepository;
import org.khmeracademy.smg_btb.service.generation.GenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerationImpl implements GenerationService{
	
	@Autowired
	private GenerationRepository generationRepository;
	
	@Override
	public ArrayList<Generation> findAll() {
		return generationRepository.findAll();
	}

	@Override
	public boolean registerGeneration(Generation generation) {
		return generationRepository.registerGeneration(generation);
	}

	@Override
	public MaxId selectMax() {
		// TODO Auto-generated method stub
		return null;
	}

}
