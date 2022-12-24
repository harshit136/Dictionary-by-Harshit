package com.example.dictionary11dec;

import java.util.HashMap;

public class DictionaryUsingHashMap {

    HashMap<String, String> dictionary;

    public DictionaryUsingHashMap() {
        this.dictionary = new HashMap<>();
        addWordList();
    }

    public boolean addWord(String word, String meaning){
        try{
            dictionary.put(word, meaning);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getMeaning(String word){
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        else{
            return "Word does not exists in dictionary!";
        }
    }

    private void addWordList() {
    //=CONCATENATE("addWord(", CHAR(34), A29, CHAR(34), ", ", CHAR(34), B29, CHAR(34), ");")
        addWord("shubh", "Auspicious");
        addWord("phase", "a stage in the development of something");
        addWord("project", "an individual or collaborative enterprise that is carefully planned to achieve a particular aim");
        addWord("start", "beginning");
        addWord("depreciating assets ", "Whose value decreases with time");

    }
}

