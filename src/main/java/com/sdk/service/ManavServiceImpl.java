package com.sdk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Manav;
import com.sdk.exception.ResourceNotFoundException;
import com.sdk.repository.ManavRepository;
@Component
public class ManavServiceImpl implements ManavService{

	@Autowired
	private ManavRepository manavRepository;
	
	@Override
	public List<Manav> getAllManav() {
		return manavRepository.getAll();
	}

	@Override
	public Manav findManavById(Integer id) {
		return manavRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Manav not found with id:"+id));
	}

	@Override
	public void saveManav(Manav manav) {
		manavRepository.save(manav);
		
	}

	@Override
	public void updateManav(Manav manav) {
		manavRepository.update(manav);
		
	}

	@Override
	public void deleteManav(Integer id) {
		manavRepository.delete(id);
		
	}

}
