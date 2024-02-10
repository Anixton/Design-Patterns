public class ContentManager {
    public static void main(String[] args) {
        ContentCache contentCache = new ContentCache();
        contentCache.loadCache();

        Content clonedArticle = contentCache.getContent("Article");
        clonedArticle.display();

        Content clonedVideo = contentCache.getContent("Video");
        clonedVideo.display();

        Content clonedImage = contentCache.getContent("Image");
        clonedImage.display();
    }
}
