package com.example.demo.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "sentenceGeEn")
public class Sentence {

    @Id
    private String id;
    private int sentenceNumber;
    private String original;
    private List<String> translations;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSentenceNumber() {
        return sentenceNumber;
    }

    public void setSentenceNumber(int sentenceNumber) {
        this.sentenceNumber = sentenceNumber;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }
}