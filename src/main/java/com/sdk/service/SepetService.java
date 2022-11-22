package com.sdk.service;

import java.util.List;

import com.sdk.domain.Sepet;

public interface SepetService {
	List<Sepet> getAllSepet();
	Sepet findSepetById(Integer id);
	void saveSepet(Sepet sepet);
	void updateSepet(Sepet sepet);
	void deleteSepet(Integer id);
}
