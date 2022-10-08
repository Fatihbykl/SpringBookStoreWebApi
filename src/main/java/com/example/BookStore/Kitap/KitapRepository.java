package com.example.BookStore.Kitap;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface KitapRepository
		extends MongoRepository<Kitap, String> {

}
