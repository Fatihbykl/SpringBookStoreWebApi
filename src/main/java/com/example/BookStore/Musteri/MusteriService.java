package com.example.BookStore.Musteri;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MusteriService {
	private final MusteriRepository musteriRepository;
	
	@Autowired
	public MusteriService(MusteriRepository r) {
		this.musteriRepository = r;
	}
	
	public ResponseEntity<List<Musteri>> musterileriGetir() {
		return ResponseEntity.ok(musteriRepository.findAll());
	}
	
	public ResponseEntity<Musteri> musteriOlustur(Musteri musteri) {
		return ResponseEntity.ok(musteriRepository.save(musteri));
	}
	
	public ResponseEntity<Musteri> musteriDuzenle(
			String id,
			Musteri musteri
	)  {
		Musteri m = musteriRepository.findById(id).get();
		m.setMusteriAd(musteri.getMusteriAd());
		m.setMusteriSoyad(musteri.getMusteriSoyad());
		m.setMusteriEmail(musteri.getMusteriEmail());
		Musteri guncelMusteri = musteriRepository.save(m);
		return ResponseEntity.ok(guncelMusteri);
		
	}
}
