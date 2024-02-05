import javax.swing.JPanel;

public class ImageProxy implements ImageInterface{
    private String fileName;
    private RealImage realImage;

    public ImageProxy(String fileName){
       this.fileName = fileName;
    }

    @Override
    public void display(JPanel panel, String imageFileName) {
       if(realImage == null){
          realImage = new RealImage(fileName);
       }
       realImage.display(panel, imageFileName);
    }
}
