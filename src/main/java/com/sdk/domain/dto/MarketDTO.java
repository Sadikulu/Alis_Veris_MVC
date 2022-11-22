package com.sdk.domain.dto;

public class MarketDTO {
	private String urunAdi;
	private Double urunFiyati;

	public MarketDTO(String urunAdi, Double urunFiyati) {
		this.urunAdi = urunAdi;
		this.urunFiyati = urunFiyati;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public Double getUrunFiyati() {
		return urunFiyati;
	}

	public void setUrunFiyati(Double urunFiyati) {
		this.urunFiyati = urunFiyati;
	}

	
}
