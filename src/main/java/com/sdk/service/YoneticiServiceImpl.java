package com.sdk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Yonetici;
import com.sdk.exception.ResourceNotFoundException;
import com.sdk.repository.YoneticiRepository;

@Component
public class YoneticiServiceImpl implements YoneticiService{

	@Autowired
	private YoneticiRepository yoneticiRepository;

	@Override
	public void saveYonetici(Yonetici yonetici) {
		yoneticiRepository.save(yonetici);
		
	}

	@Override
	public List<Yonetici> getAllYonetici() {
		return yoneticiRepository.getAll();
	}

	@Override
	public List<String> getYoneticiUserName() {
		return yoneticiRepository.getAllUserName();
	}

	@Override
	public List<String> getYoneticiPassword() {
		return yoneticiRepository.getAllPassword();
	}

	@Override
	public void updateYonetici(Yonetici yonetici) {
		yoneticiRepository.update(yonetici);
		
	}

	@Override
	public void deleteYonetici(Integer id) {
		yoneticiRepository.delete(id);
		
	}

	@Override
	public Yonetici findYoneticiById(Integer id) {
		return yoneticiRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Yonetici not found with id:"+id));
	}
}
