package com.sdk.service;

import java.util.List;

import com.sdk.domain.Kullanici;

public interface KullaniciService {
	List<String> getkullaniciUserName();
	List<String> getKullaniciPassword();
	List<Kullanici> getAllKullanici();
	void saveKullanici(Kullanici kullanici);
}
