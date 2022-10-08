package com.example.BookStore.Yazar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class YazarService {
	private final YazarRepository yazarRepository;
	
	@Autowired
	public YazarService(YazarRepository _yazarRepository) {
		this.yazarRepository = _yazarRepository;
	}
	
	public ResponseEntity<List<Yazar>> yazarlariGetir() {
		return ResponseEntity.ok(yazarRepository.findAll());
	}
	
	public ResponseEntity<Yazar> yazarGetir(String id) {
		return ResponseEntity.ok(yazarRepository.findById(id).get());
	}
		
	public ResponseEntity<Yazar> yazarOlustur(Yazar yazar) {
		return ResponseEntity.ok(yazarRepository.save(yazar));
	}
	
	public ResponseEntity<Yazar> yazarDuzenle(
			String id,
			Yazar yazar
	) {
		Yazar _yazar = yazarRepository.findById(id).get();
		_yazar.setYazarAd(yazar.getYazarAd());
		Yazar guncelYazar = yazarRepository.save(_yazar);
		return ResponseEntity.ok(guncelYazar);
	}
}
