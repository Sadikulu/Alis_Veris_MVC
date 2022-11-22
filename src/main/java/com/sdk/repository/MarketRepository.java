package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import com.sdk.domain.Market;



public interface MarketRepository {
	List<Market> getAll();
	Optional<Market> findById(Integer id);
	void save(Market market);
	void update(Market market);
	void delete(Integer id);
}
