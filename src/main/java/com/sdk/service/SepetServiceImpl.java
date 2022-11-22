package com.sdk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Sepet;
import com.sdk.exception.ResourceNotFoundException;
import com.sdk.repository.SepetRepository;

@Component
public class SepetServiceImpl implements SepetService{

	@Autowired
	private SepetRepository sepetRepository;

	@Override
	public List<Sepet> getAllSepet() {
		return sepetRepository.getAll();
	}

	@Override
	public Sepet findSepetById(Integer id) {
		return sepetRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Sepet not found with id:"+id));
	}
	
	@Override
	public void saveSepet(Sepet sepet) {
		sepetRepository.save(sepet);
		
	}

	@Override
	public void updateSepet(Sepet sepet) {
		sepetRepository.update(sepet);
		
	}

	@Override
	public void deleteSepet(Integer id) {
		sepetRepository.delete(id);
		
	}
}
