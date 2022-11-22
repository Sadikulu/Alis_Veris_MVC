package com.sdk.service;

import java.util.List;

import com.sdk.domain.Yonetici;

public interface YoneticiService {
	List<String> getYoneticiUserName();
	List<String> getYoneticiPassword();
	List<Yonetici> getAllYonetici();
	Yonetici findYoneticiById(Integer id);
	void saveYonetici(Yonetici yonetici);
	void updateYonetici(Yonetici yonetici);
	void deleteYonetici(Integer id);
}
