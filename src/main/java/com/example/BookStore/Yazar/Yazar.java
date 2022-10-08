package com.example.BookStore.Yazar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.BookStore.Kitap.Kitap;

import lombok.Data;

@Data
@Document
public class Yazar {
	@Id
	private String yazarID;
	private String yazarAd;
	
	@OneToMany(mappedBy = "yazar")
	private Set<Kitap> kitaplar = new HashSet<>();
	
	public void kitapEkle(Kitap kitap) {
		kitaplar.add(kitap);
	}

	// getters and setters
	
	public String getYazarAd() {
		return yazarAd;
	}

	public void setYazarAd(String yazarAd) {
		this.yazarAd = yazarAd;
	}

	public String getYazarID() {
		return yazarID;
	}

	public Set<Kitap> getKitaplar() {
		return kitaplar;
	}
	
	
}
