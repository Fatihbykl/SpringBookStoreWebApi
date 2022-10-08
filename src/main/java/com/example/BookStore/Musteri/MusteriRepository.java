package com.example.BookStore.Musteri;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusteriRepository
		extends MongoRepository<Musteri, String> {
}
