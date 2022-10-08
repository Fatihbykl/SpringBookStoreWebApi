package com.example.BookStore.Adres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/adresler")
public class AdresController {
	private final AdresService adresService;
	
	@Autowired
	public AdresController(AdresService s) {
		this.adresService = s;
	}
	
	@PostMapping
	public ResponseEntity<Adres> adresOlustur(@RequestBody Adres adres) {
		return adresService.adresOlustur(adres);
	}
	
	@PutMapping
	public ResponseEntity<Adres> adresDuzenle(
			String id,
			@RequestBody Adres adres
	) {
		return adresService.adresDuzenle(id, adres);
	}
}
