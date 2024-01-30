import java.util.Map;
import java.util.HashMap;

public class ContentCache {
    private Map<String, Content> contentCache = new HashMap<>();

    public void loadCache() {
        contentCache.put("Article", new Article("Default Article"));
        contentCache.put("Video", new Video("Default Video"));
        contentCache.put("Image", new Image("Default Image"));
    }

    public Content getContent(String contentType) {
        Content cachedContent = contentCache.get(contentType);
        return cachedContent != null ? cachedContent.clone() : null;
    }
}