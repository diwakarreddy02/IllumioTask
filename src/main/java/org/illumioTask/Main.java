package org.illumioTask;

import org.illumioTask.reader.FilesReader;
import org.illumioTask.reader.PredefinedWordsReader;
import org.illumioTask.matcher.WordMatcher;
import org.illumioTask.model.MatchResult;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to the input file:");
        String inputFilePath = scanner.nextLine();

        System.out.println("Enter the path to the predefined words file:");
        String predefinedWordsFilePath = scanner.nextLine();

        try {
            FilesReader filesReader = new FilesReader();
            List<String> fileWords = filesReader.readFile(inputFilePath);

            PredefinedWordsReader predefinedWordsReader = new PredefinedWordsReader();
            List<String> predefinedWords = predefinedWordsReader.getPredefinedWordsList(predefinedWordsFilePath);
            WordMatcher wordMatcher = new WordMatcher(predefinedWords);

            wordMatcher.matchWords(fileWords);
            List<MatchResult> matchResults = wordMatcher.getMatchResults(predefinedWords);

            printMatchResults(matchResults);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printMatchResults(List<MatchResult> matchResults) {
        System.out.printf("%-20s %s%n", "Predefined word", "Match count");
        for (MatchResult result : matchResults) {
            System.out.printf("%-20s %d%n", result.getWord(), result.getCount());
        }
    }

}