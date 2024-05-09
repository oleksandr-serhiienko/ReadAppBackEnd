package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Sentence;

import java.util.List;
import java.util.Optional;

@Repository
public interface SentenceRepository extends MongoRepository<Sentence, String> {
    List<Sentence> findBySentenceNumberBetween(int start, int end);
    List<Sentence> findTop20ByOrderBySentenceNumberAsc();
    Optional<Sentence> findBySentenceNumber(int sentenceNumber);
}
