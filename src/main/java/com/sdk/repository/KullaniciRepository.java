package com.sdk.repository;

import java.util.List;

import com.sdk.domain.Kullanici;

public interface KullaniciRepository {
	List<String> getAllUserName();
	List<String> getAllPassword();
	List<Kullanici> getAll();
	void save(Kullanici kullanici);
}
