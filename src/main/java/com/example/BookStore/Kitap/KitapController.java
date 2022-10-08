package com.example.BookStore.Kitap;

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
//@RequestMapping("api/kitaplar")
public class KitapController {
	private final KitapService kitapService;
	
	@Autowired
	public KitapController(KitapService s) {
		this.kitapService = s;
	}
	
	@GetMapping("api/kitaplar")
	public ResponseEntity<List<Kitap>> kitaplariGetir() {
		return kitapService.kitaplariGetir();
	}
	
	@GetMapping("api/kitaplar/{kitapID}")
	public ResponseEntity<Kitap> kitapGetir(@PathVariable("kitapID") String id) {
		return kitapService.kitapGetir(id);
	}
	
	@PostMapping("api/kitaplar")
	public ResponseEntity<Kitap> kitapOlustur(@RequestBody Kitap kitap) {
		return kitapService.kitapOlustur(kitap);
	}
	
	@PutMapping("api/kitaplar/{kitapID}")
	public ResponseEntity<Kitap> kitapDuzenle(
			@PathVariable("kitapID") String id,
			@RequestBody Kitap kitap
	) {
		return kitapService.kitapDuzenle(id, kitap);
	}
}
