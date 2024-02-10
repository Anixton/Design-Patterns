public class Article implements Content {
    private String title;

    public Article(String title) {
        this.title = title;
    }

    @Override
    public Content clone() {
        return new Article(this.title);
    }

    @Override
    public void display() {
        System.out.println("Article: " + title);
    }
}