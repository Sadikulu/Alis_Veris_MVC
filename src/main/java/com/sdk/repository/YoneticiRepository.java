package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import com.sdk.domain.Yonetici;

public interface YoneticiRepository {
	List<String> getAllUserName();
	List<String> getAllPassword();
	List<Yonetici> getAll();
	Optional<Yonetici> findById(Integer id);
	void save(Yonetici yonetici);
	void update(Yonetici yonetici);
	void delete(Integer id);
}
