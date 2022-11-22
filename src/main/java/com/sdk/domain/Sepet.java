package com.sdk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Sepet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotEmpty(message = "Urunu adi bolumunu bos birakamazsiniz")
    private String urunAdi;

    @NotNull(message = "Fiyat bolumunu bos birakamazsiniz")
    private Double urunFiyati;
    
    @NotNull(message = "Adet bolumunu bos birakamazsiniz")
    private Integer adet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAdet() {
		return adet;
	}

	public void setAdet(Integer adet) {
		this.adet = adet;
	}
}
