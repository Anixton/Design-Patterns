// This class is the real image class which implements the 
// ImageInterface and loads the image from the disk.

import javax.swing.*;
import java.awt.*;

public class RealImage implements ImageInterface{
   private String fileName;

   public RealImage(String fileName){
      this.fileName = fileName;
      loadFromDisk();
   }

   private void loadFromDisk(){
      System.out.println("Loading image: " + fileName);
   }

   @Override
   public void display(JPanel panel, String imageFileName) {
      JLabel label = new JLabel("Displaying image: ");
      label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
      panel.add(label);

      // Customizing font
      Font customFont = new Font("Consolas", Font.PLAIN, 15);
      label.setFont(customFont);
   }
}
