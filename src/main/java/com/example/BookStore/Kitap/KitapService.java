package com.example.BookStore.Kitap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.BookStore.Yazar.Yazar;
import com.example.BookStore.Yazar.YazarRepository;

@Service
public class KitapService {
	private final KitapRepository kitapRepository;
	private final YazarRepository yazarRepository;
	
	@Autowired
	public KitapService(KitapRepository _kitapRepository, YazarRepository _yazarRepository) {
		this.kitapRepository = _kitapRepository;
		this.yazarRepository = _yazarRepository;
	}
	
	public ResponseEntity<List<Kitap>> kitaplariGetir() {
		return ResponseEntity.ok(kitapRepository.findAll());
	}
	
	public ResponseEntity<Kitap> kitapGetir(String id) {
		return ResponseEntity.ok(kitapRepository.findById(id).get());
	}
	
	public ResponseEntity<Kitap> kitapOlustur(@RequestBody Kitap kitap) {
		Yazar yazar = yazarRepository.findById(kitap.getYazar().getYazarID()).get();
		kitap.setYazar(yazar);
		return ResponseEntity.ok(kitapRepository.save(kitap));
	}
	
	public ResponseEntity<Kitap> kitapDuzenle(
			String id,
			@RequestBody Kitap kitap
	) {
		Kitap _kitap = kitapRepository.findById(id).get();
		_kitap.setBasimTarihi(kitap.getBasimTarihi());
		_kitap.setBaslik(kitap.getBaslik());
		_kitap.setFiyat(kitap.getFiyat());
		_kitap.setGorselURL(kitap.getGorselURL());
		_kitap.setSayfaSayisi(kitap.getSayfaSayisi());
		_kitap.setStokSayisi(kitap.getStokSayisi());
		_kitap.setTur(kitap.getTur());
		Kitap guncelKitap = kitapRepository.save(_kitap);
		return ResponseEntity.ok(guncelKitap);
	}
	
}
