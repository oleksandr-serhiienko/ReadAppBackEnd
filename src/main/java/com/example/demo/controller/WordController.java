package com.example.demo.controller;

import com.example.demo.domain.Word;
import com.example.demo.repository.WordRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/words")
public class WordController {

    @Autowired
    private WordRepository wordRepository;

    // POST endpoint to create or update a word
    @PostMapping
    public Word saveWord(@RequestBody Word word) {
        return wordRepository.save(word);
    }

    // GET endpoint to retrieve a word by its name
    @GetMapping("/{word}")
    public ResponseEntity<Word> getWord(@PathVariable String word) {
        Optional<Word> test = wordRepository.findByWord(word);
        return wordRepository.findByWord(word)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to get the first five words
    @GetMapping("/first-five")
    public List<Word> getFirstFiveWords() {
        List<Word> words = wordRepository.findFirst5ByOrderByWordAsc();
        System.out.println("Number of words fetched: " + words.size());
        return wordRepository.findFirst5ByOrderByWordAsc();
    }

    // DELETE endpoint to delete a word by its name
    @DeleteMapping("/{word}")
    public ResponseEntity<Void> deleteWord(@PathVariable String word) {
        return wordRepository.findByWord(word)
                .map(foundWord -> {
                    wordRepository.delete(foundWord);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
