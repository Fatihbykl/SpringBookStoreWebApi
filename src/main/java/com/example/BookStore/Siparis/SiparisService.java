package com.example.BookStore.Siparis;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookStore.Adres.Adres;
import com.example.BookStore.Adres.AdresRepository;
import com.example.BookStore.Kitap.Kitap;
import com.example.BookStore.Kitap.KitapRepository;
import com.example.BookStore.Musteri.Musteri;
import com.example.BookStore.Musteri.MusteriRepository;

@Service
public class SiparisService {
	private final SiparisRepository siparisRepository;
	private final MusteriRepository musteriRepository;
	private final AdresRepository adresRepository;
	private final KitapRepository kitapRepository;
	
	@Autowired
	public SiparisService(
			SiparisRepository _siparisRepository,
			MusteriRepository _musteriRepository,
			AdresRepository _adresRepository,
			KitapRepository _kitapRepository
	) {
		this.siparisRepository = _siparisRepository;
		this.adresRepository = _adresRepository;
		this.musteriRepository = _musteriRepository;
		this.kitapRepository = _kitapRepository;
	}
	
	public ResponseEntity<Set<Siparis>> kullanicininSiparisleriGetir(String id) {
		Musteri _musteri = musteriRepository.findById(id).get();
		return ResponseEntity.ok(_musteri.getSiparisler());
	}
	
	public ResponseEntity<Siparis> siparisOlustur(Siparis siparis) {
		Musteri _musteri = musteriRepository.findById(siparis.getMusteri().getMusteriID()).get();
		Adres _adres = adresRepository.findById(siparis.getAdres().getAdresID()).get();
		float toplamTutar = 0;
		Set<Kitap> kitaplar = new HashSet<>();
		for (var kitap : siparis.getKitaplar()) {
			Kitap _kitap = kitapRepository.findById(kitap.getKitapID()).get();
			toplamTutar += _kitap.getFiyat();
			kitaplar.add(_kitap);
		}
		siparis.setAdres(_adres);
		siparis.setMusteri(_musteri);
		siparis.setKitaplar(kitaplar);
		siparis.setSiparisTutari(toplamTutar);
		siparis.setSiparisTarihi(LocalDateTime.now());
		return ResponseEntity.ok(siparisRepository.save(siparis));
	}
}
