package com.socialmedia;

public interface Visitor {
    void visit(TextPost textPost);
    void visit(ImagePost imagePost);
    void visit(VideoPost videoPost);
}
