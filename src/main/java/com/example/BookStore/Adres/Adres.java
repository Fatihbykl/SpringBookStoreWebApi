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
	
	@OneToMany(mappedBy = "adres")
	private Set<Siparis> siparisler = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="musteri_id", referencedColumnName="musteriID")
	private Musteri adresSahibi;
	
	public void siparisEkle(Siparis siparis) {
		siparisler.add(siparis);
	}
}
