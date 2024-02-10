public class Video implements Content {
    private String videoTitle;

    public Video(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    @Override
    public Content clone() {
        return new Video(this.videoTitle);
    }

    @Override
    public void display() {
        System.out.println("Video: " + videoTitle);
    }
}