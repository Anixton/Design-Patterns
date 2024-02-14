package com.socialmedia;

public class VideoPost implements Post{
    private String title;
    private String videoURL;

    public VideoPost(String title,String videoURL) {
        this.title = title;
        this.videoURL = videoURL;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoURL() {
        return videoURL;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
