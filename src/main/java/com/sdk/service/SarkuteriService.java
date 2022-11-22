package com.sdk.service;

import java.util.List;

import com.sdk.domain.Sarkuteri;

public interface SarkuteriService {
	List<Sarkuteri> getAllSarkuteri();
	Sarkuteri findSarkuteriById(Integer id);
	void saveSarkuteri(Sarkuteri sarkuteri);
	void updateSarkuteri(Sarkuteri sarkuteri);
	void deleteSarkuteri(Integer id);
}
