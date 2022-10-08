package com.example.BookStore.Siparis;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCreation;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.BookStore.Adres.Adres;
import com.example.BookStore.Kitap.Kitap;
import com.example.BookStore.Musteri.Musteri;
import com.example.BookStore.Yazar.Yazar;

import lombok.Data;

@Data
@Document
public class Siparis {
	@Id
	private String siparisID;
	private LocalDateTime siparisTarihi;
	private float siparisTutari;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adres_id", referencedColumnName="adresID")
	private Adres adres;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="musteri_id", referencedColumnName="musteriID")
	private Musteri musteri;
	
	@ManyToMany
	@JoinTable(
			name = "SiparisKitap",
			joinColumns = @JoinColumn(name = "siparis_id"),
			inverseJoinColumns = @JoinColumn(name = "kitap_id")	
    )
	private Set<Kitap> kitaplar = new HashSet<>();
	
	// getters and setters
	
	public void kitapEkle(Kitap kitap) {
		kitaplar.add(kitap);
	}

	public void setKitaplar(Set<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}


	public LocalDateTime getSiparisTarihi() {
		return siparisTarihi;
	}

	public void setSiparisTarihi(LocalDateTime siparisTarihi) {
		this.siparisTarihi = siparisTarihi;
	}

	public float getSiparisTutari() {
		return siparisTutari;
	}

	public void setSiparisTutari(float siparisTutari) {
		this.siparisTutari = siparisTutari;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	public String getSiparisID() {
		return siparisID;
	}

	public Set<Kitap> getKitaplar() {
		return kitaplar;
	}
	
	
}
