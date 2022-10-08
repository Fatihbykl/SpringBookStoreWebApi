package com.example.BookStore.Musteri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Musteri> musterileriGetir() {
		return musteriService.musterileriGetir();
	}
	
	@PostMapping
	public Musteri musteriOlustur(@RequestBody Musteri musteri) {
		return musteriService.musteriOlustur(musteri);
	}
}