package com.sdk.service;

import java.util.List;

import com.sdk.domain.Manav;

public interface ManavService {
	List<Manav> getAllManav();
	Manav findManavById(Integer id);
	void saveManav(Manav manav);
	void updateManav(Manav manav);
	void deleteManav(Integer id);
}
