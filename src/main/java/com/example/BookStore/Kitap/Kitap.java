package com.example.BookStore.Kitap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.BookStore.Siparis.Siparis;
import com.example.BookStore.Yazar.Yazar;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Document
public class Kitap {
	@Id
	private String kitapID;
	private String baslik;
	private String basimTarihi;
	private String tur;
	private String gorselURL;
	private int sayfaSayisi;
	private int stokSayisi;
	private float fiyat;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="yazar_id", referencedColumnName="yazarID")
	private Yazar yazar;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "kitaplar")
	private Set<Siparis> siparisler = new HashSet<>();

	// getters and setters
	
	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getBasimTarihi() {
		return basimTarihi;
	}

	public void setBasimTarihi(String basimTarihi) {
		this.basimTarihi = basimTarihi;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public String getGorselURL() {
		return gorselURL;
	}

	public void setGorselURL(String gorselURL) {
		this.gorselURL = gorselURL;
	}

	public int getSayfaSayisi() {
		return sayfaSayisi;
	}

	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}

	public int getStokSayisi() {
		return stokSayisi;
	}

	public void setStokSayisi(int stokSayisi) {
		this.stokSayisi = stokSayisi;
	}

	public float getFiyat() {
		return fiyat;
	}

	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}

	public Yazar getYazar() {
		return yazar;
	}

	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}

	public String getKitapID() {
		return kitapID;
	}
	
	
}
