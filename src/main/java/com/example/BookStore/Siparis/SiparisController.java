package com.example.BookStore.Siparis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiparisController {
	private final SiparisService siparisService;
	
	@Autowired
	public SiparisController(SiparisService s) {
		this.siparisService = s;
	}
	
	@GetMapping("api/siparisler/{musteriID}")
	public ResponseEntity<Set<Siparis>> kullanicininSiparisleriGetir(
			@PathVariable("musteriID") String id
	) {
		return siparisService.kullanicininSiparisleriGetir(id);
	}
	
	@PostMapping("api/siparisler")
	public ResponseEntity<Siparis> siparisOlustur(
			@RequestBody Siparis siparis
	) {
		return siparisService.siparisOlustur(siparis);
	}
}
