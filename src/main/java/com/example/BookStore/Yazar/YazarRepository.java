package com.example.BookStore.Yazar;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface YazarRepository
		extends MongoRepository<Yazar, String> {
}
