package com.example.BookStore.Yazar;

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

@RestController
public class YazarController {
	private final YazarService yazarService;
	
	@Autowired
	public YazarController(YazarService _yazarService) {
		this.yazarService = _yazarService;
	}
	
	@GetMapping("api/yazarlar")
	public ResponseEntity<List<Yazar>> yazarlariGetir() {
		return yazarService.yazarlariGetir();
	}
	
	@GetMapping("api/yazarlar/{yazarID}")
	public ResponseEntity<Yazar> yazarGetir(@PathVariable("yazarID") String id) {
		return yazarService.yazarGetir(id);
	}
	
	@PostMapping("api/yazarlar")
	public ResponseEntity<Yazar> yazarOlustur(@RequestBody Yazar yazar) {
		return yazarService.yazarOlustur(yazar);
	}
	
	@PutMapping("api/yazarlar/{yazarID}")
	public ResponseEntity<Yazar> yazarDuzenle(
			@PathVariable("yazarID") String id,
			@RequestBody Yazar yazar
	) {
		return yazarService.yazarDuzenle(id, yazar);
	}
}
