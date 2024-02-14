package com.socialmedia;

public class PostCounter implements Visitor {
    private int count = 0;

    @Override
    public void visit(TextPost textPost) {
        count++;
    }

    @Override
    public void visit(ImagePost imagePost) {
        count++;
    }

    @Override
    public void visit(VideoPost videoPost) {
        count++;
    }

    public int getCount() {
        return count;
    }
}