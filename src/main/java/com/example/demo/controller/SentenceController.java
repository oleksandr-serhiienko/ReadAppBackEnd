package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Sentence;
import com.example.demo.repository.SentenceRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class SentenceController {

    @Autowired
    private SentenceRepository sentenceRepository;

    @GetMapping("/sentences")
    public List<Sentence> getSentences() {
        return sentenceRepository.findTop20ByOrderBySentenceNumberAsc();
    }

    @GetMapping("/sentence/{sentenceNumber}")
    public ResponseEntity<Sentence> getSentenceByNumber(@PathVariable int sentenceNumber) {
        Optional<Sentence> sentence = sentenceRepository.findBySentenceNumber(sentenceNumber);
        return sentence.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/sentences/around/{sentenceNumber}")
    public List<Sentence> getSentencesAround(@PathVariable int sentenceNumber) {
        int startSentenceNumber = Math.max(0, sentenceNumber - 10);
        int endSentenceNumber = sentenceNumber + 10;
        return sentenceRepository.findBySentenceNumberBetween(startSentenceNumber, endSentenceNumber);
    }
}