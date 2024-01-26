public class Image implements Content {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public Content clone() {
        return new Image(this.imageName);
    }

    @Override
    public void display() {
        System.out.println("Image: " + imageName);
    }
}