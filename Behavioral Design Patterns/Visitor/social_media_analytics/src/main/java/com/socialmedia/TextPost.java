package com.socialmedia;

public class TextPost implements Post {
    private String text;
    private String title;

    public TextPost(String title,String text) {
        this.text = text;
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
