package com.example.BookStore.Adres;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.BookStore.Musteri.Musteri;
import com.example.BookStore.Siparis.Siparis;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Document
public class Adres {
	@Id
	private String adresID;
	private String il;
	private String ilce;
	private String sokak;
	private String mahalle;
	private int no;
	
	@JsonIgnore
	@OneToMany(mappedBy = "adres")
	private Set<Siparis> siparisler = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="musteri_id", referencedColumnName="musteriID")
	private Musteri adresSahibi;
	
	public void siparisEkle(Siparis siparis) {
		siparisler.add(siparis);
	}
	
	// getters and setters

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public String getSokak() {
		return sokak;
	}

	public void setSokak(String sokak) {
		this.sokak = sokak;
	}

	public String getMahalle() {
		return mahalle;
	}

	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Musteri getAdresSahibi() {
		return adresSahibi;
	}

	public void setAdresSahibi(Musteri adresSahibi) {
		this.adresSahibi = adresSahibi;
	}

	public String getAdresID() {
		return adresID;
	}

	public Set<Siparis> getSiparisler() {
		return siparisler;
	}
	
	
}
