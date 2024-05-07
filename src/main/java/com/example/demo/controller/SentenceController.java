package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Sentence;
import com.example.demo.repository.SentenceRepository;

import java.util.List;

@RestController
public class SentenceController {

    @Autowired
    private SentenceRepository sentenceRepository;

    @GetMapping("/sentences")
    public List<Sentence> getSentences() {
        return sentenceRepository.findTop20ByOrderBySentenceNumberAsc();
    }
}