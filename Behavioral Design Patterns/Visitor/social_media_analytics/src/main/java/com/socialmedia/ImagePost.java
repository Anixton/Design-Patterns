package com.socialmedia;

public class ImagePost implements Post {
    private String title;
    private String imageURL;

    public ImagePost(String title,String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
