package com.example.BookStore.Musteri;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MusteriService {
	private final MusteriRepository musteriRepository;
	
	@Autowired
	public MusteriService(MusteriRepository r) {
		this.musteriRepository = r;
	}
	
	public List<Musteri> musterileriGetir() {
		return musteriRepository.findAll();
	}
	
	public Musteri musteriOlustur(Musteri musteri) {
		return musteriRepository.save(musteri);		
	}
}
