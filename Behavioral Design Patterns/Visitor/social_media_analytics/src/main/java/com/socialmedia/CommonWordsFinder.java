package com.socialmedia;

import java.util.HashMap;

public class CommonWordsFinder implements Visitor {
    private int commonWordCount = 0;
    private HashMap <String, Integer> wordCount = new HashMap<>();

    @Override
    public void visit(TextPost textPost) {
        String[] words = textPost.getText().split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        words = textPost.getTitle().split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

    @Override
    public void visit(ImagePost imagePost) {
        String[] words = imagePost.getTitle().split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String[] urlWords = imagePost.getImageURL().split("/");
        for (String word : urlWords) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

    @Override
    public void visit(VideoPost videoPost) {
        String[] words = videoPost.getTitle().split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String[] urlWords = videoPost.getVideoURL().split("/");
        for (String word : urlWords) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

    public int getCommonWordCount() {
        for (int count : wordCount.values()) {
            if (count > 1) {
                commonWordCount++;
            }
        }
        return commonWordCount;
    }

    public void displayCommonWords() {
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) > 1) {
                System.out.println(word + " : " + wordCount.get(word));
            }
        }
    }
}
