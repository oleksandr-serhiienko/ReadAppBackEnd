package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "wordsGeEn")
public class Word {
    
    private String word;
    private List<String> translations;

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }
}
