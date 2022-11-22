package com.sdk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Sarkuteri;
import com.sdk.exception.ResourceNotFoundException;
import com.sdk.repository.SarkuteriRepository;

@Component
public class SarkuteriServiceImpl implements SarkuteriService{

	@Autowired
	private SarkuteriRepository sarkuteriRepository;
	
	@Override
	public List<Sarkuteri> getAllSarkuteri() {
		return sarkuteriRepository.getAll();
	}

	@Override
	public Sarkuteri findSarkuteriById(Integer id) {
		return sarkuteriRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Market not found with id:"+id));
	}

	@Override
	public void saveSarkuteri(Sarkuteri sarkuteri) {
		sarkuteriRepository.save(sarkuteri);	
	}

	@Override
	public void updateSarkuteri(Sarkuteri sarkuteri) {
		sarkuteriRepository.update(sarkuteri);
	}

	@Override
	public void deleteSarkuteri(Integer id) {
		sarkuteriRepository.delete(id);
	}

}
