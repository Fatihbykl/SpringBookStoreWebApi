package com.example.BookStore.Musteri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/musteriler")
@AllArgsConstructor
public class MusteriController {
	private final MusteriService musteriService;
	
	@Autowired
	public MusteriController(MusteriService s) {
		this.musteriService = s;
	}
	
	@GetMapping
	public ResponseEntity<List<Musteri>> musterileriGetir() {
		return musteriService.musterileriGetir();
	}
	
	@PostMapping
	public ResponseEntity<Musteri> musteriOlustur(@RequestBody Musteri musteri) {
		return musteriService.musteriOlustur(musteri);
	}
	
	@PutMapping
	public ResponseEntity<Musteri> musteriDuzenle(
			String id,
			@RequestBody Musteri musteri
	) {
		return musteriService.musteriDuzenle(id, musteri);
	}
	
}
