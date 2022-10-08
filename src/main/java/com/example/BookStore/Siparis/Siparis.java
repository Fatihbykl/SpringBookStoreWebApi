package com.example.BookStore.Siparis;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	private ZonedDateTime siparisTarihi;
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
	
	public void kitapEkle(Kitap kitap) {
		kitaplar.add(kitap);
	}
}
