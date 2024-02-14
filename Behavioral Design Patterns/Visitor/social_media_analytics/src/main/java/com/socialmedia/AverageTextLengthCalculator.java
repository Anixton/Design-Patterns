package com.socialmedia;

public class AverageTextLengthCalculator implements Visitor {
    private int charCount = 0;
    private int postCount = 0;

    @Override
    public void visit(TextPost textPost) {
        charCount += textPost.getTitle().length();
        charCount += textPost.getText().length();
        postCount++;
    }

    @Override
    public void visit(ImagePost imagePost) {
        charCount += imagePost.getTitle().length();
        charCount += imagePost.getImageURL().length();
        postCount++;
    }

    @Override
    public void visit(VideoPost videoPost) {
        charCount += videoPost.getTitle().length();
        charCount += videoPost.getVideoURL().length();
        postCount++;
    }

    public double getAverageTextLength() {
        return charCount/postCount;
    }
}
