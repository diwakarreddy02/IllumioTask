package org.illumioTask.model;

public class MatchResult {

    private final String word;
    private final int count;

    public MatchResult(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

}
