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
	
	@ManyToMany(mappedBy = "kitaplar")
	private Set<Siparis> siparisler = new HashSet<>();
}
