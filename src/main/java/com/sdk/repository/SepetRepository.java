package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import com.sdk.domain.Sepet;



public interface SepetRepository {
	List<Sepet> getAll();
	Optional<Sepet> findById(Integer id);
	void save(Sepet sepet);
	void update(Sepet sepet);
	void delete(Integer id);
}
