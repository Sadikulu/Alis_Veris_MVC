package com.sdk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Kullanici;
import com.sdk.repository.KullaniciRepository;

@Component
public class KullaniciServiceImpl implements KullaniciService{

	@Autowired
	private KullaniciRepository kullaniciRepository;

	@Override
	public void saveKullanici(Kullanici kullanici) {
		kullaniciRepository.save(kullanici);
		
	}

	@Override
	public List<Kullanici> getAllKullanici() {
		return kullaniciRepository.getAll();
	}

	@Override
	public List<String> getkullaniciUserName() {
		return kullaniciRepository.getAllUserName();
	}

	@Override
	public List<String> getKullaniciPassword() {
		return kullaniciRepository.getAllPassword();
	}





}
