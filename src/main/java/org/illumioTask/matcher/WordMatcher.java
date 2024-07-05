package org.illumioTask.matcher;


import org.illumioTask.model.MatchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordMatcher {

    private HashMap<String, Integer> predefinedWordsMap;

    public WordMatcher(List<String> predefinedWords) {
        this.predefinedWordsMap = (HashMap<String, Integer>) predefinedWords.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toMap(word -> word, word -> 0));
    }

    public void matchWords(List<String> fileWords) {
        for (String word : fileWords) {

            if( predefinedWordsMap.containsKey(word) ) {
                predefinedWordsMap.put(word, predefinedWordsMap.get(word) + 1);
            }
        }
    }

    public List<MatchResult> getMatchResults(List<String> predefinedWords) {
        return predefinedWords.stream()
                .map(word -> new MatchResult(word, predefinedWordsMap.getOrDefault(word.toLowerCase(), 0)))
                .collect(Collectors.toList());
    }

}


