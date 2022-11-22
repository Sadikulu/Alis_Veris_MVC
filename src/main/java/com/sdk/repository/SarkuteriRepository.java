package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import com.sdk.domain.Sarkuteri;



public interface SarkuteriRepository {
	List<Sarkuteri> getAll();
	Optional<Sarkuteri> findById(Integer id);
	void save(Sarkuteri sarkuteri);
	void update(Sarkuteri sarkuteri);
	void delete(Integer id);
}
