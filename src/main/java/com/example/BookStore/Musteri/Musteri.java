package com.example.BookStore.Musteri;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.BookStore.Adres.Adres;
import com.example.BookStore.Siparis.Siparis;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
public class Musteri {
	@Id
	private String musteriID;
	private String musteriAd;
	private String musteriSoyad;
	private String musteriSifre;
	private String musteriEmail;
	private String rol;
	
	
	@OneToMany(mappedBy = "musteri")
	private Set<Siparis> siparisler = new HashSet<>();
	
	@OneToMany(mappedBy = "adresSahibi")
	private Set<Adres> adresler = new HashSet<>();
	
	public void siparisEkle(Siparis siparis) {
		siparisler.add(siparis);
	}
	
	public void adresEkle(Adres adres) {
		adresler.add(adres);
	}
	
	// getters and setters
	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	public String getMusteriSoyad() {
		return musteriSoyad;
	}

	public void setMusteriSoyad(String musteriSoyad) {
		this.musteriSoyad = musteriSoyad;
	}

	public String getMusteriSifre() {
		return musteriSifre;
	}

	public void setMusteriSifre(String musteriSifre) {
		this.musteriSifre = musteriSifre;
	}

	public String getMusteriEmail() {
		return musteriEmail;
	}

	public void setMusteriEmail(String musteriEmail) {
		this.musteriEmail = musteriEmail;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getMusteriID() {
		return musteriID;
	}

	public Set<Siparis> getSiparisler() {
		return siparisler;
	}

	public Set<Adres> getAdresler() {
		return adresler;
	}
}
