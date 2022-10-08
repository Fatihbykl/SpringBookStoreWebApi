package com.example.BookStore.Adres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookStore.Musteri.Musteri;
import com.example.BookStore.Musteri.MusteriRepository;

@Service
public class AdresService {
	private final AdresRepository adresRepository;
	private final MusteriRepository musteriRepository;
	
	@Autowired
	public AdresService(AdresRepository _adresRepository, MusteriRepository _musteriRepository) {
		this.adresRepository = _adresRepository;
		this.musteriRepository = _musteriRepository;
	}
	
	public ResponseEntity<Adres> adresOlustur(Adres adres) {
		Musteri _musteri = musteriRepository.findById(adres.getAdresSahibi().getMusteriID()).get();
		adres.setAdresSahibi(_musteri);
		return ResponseEntity.ok(adresRepository.save(adres));
	}
	
	public ResponseEntity<Adres> adresDuzenle(
			String id,
			Adres adres
	) {
		Adres _adres = adresRepository.findById(id).get();
		_adres.setIl(adres.getIl());
		_adres.setIlce(adres.getIlce());
		_adres.setMahalle(adres.getMahalle());
		_adres.setNo(adres.getNo());
		_adres.setSokak(adres.getSokak());
		Adres guncelAdres = adresRepository.save(_adres);
		return ResponseEntity.ok(guncelAdres);
	}
}
