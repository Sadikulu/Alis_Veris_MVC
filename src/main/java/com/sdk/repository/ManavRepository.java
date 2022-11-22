package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import com.sdk.domain.Manav;



public interface ManavRepository {
	List<Manav> getAll();
	Optional<Manav> findById(Integer id);
	void save(Manav manav);
	void update(Manav manav);
	void delete(Integer id);
}
