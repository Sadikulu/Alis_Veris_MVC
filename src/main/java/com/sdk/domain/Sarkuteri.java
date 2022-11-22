package com.sdk.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Sarkuteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Urun adi bos olamaz")
    private String urunAdi;

    @NotNull(message = "Urun fiyati bos olamaz")
    private Double urunFiyati;
    
    private LocalDateTime createDate=LocalDateTime.now();

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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
}
