package com.example.demo.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Word;

import java.util.Optional;

@Repository
public interface WordRepository extends MongoRepository<Word, String> {
    Optional<Word> findByWord(String word);
    List<Word> findFirst5ByOrderByWordAsc();
}
