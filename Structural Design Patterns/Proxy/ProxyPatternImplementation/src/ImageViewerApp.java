//*******************************************************************************************
//*  Hakan Gezginci
//* 
//* This application uses the Proxy design pattern. This pattern provides a placeholder (proxy) for an object.
//* The proxy manages the creation and access of the real object. It allows interaction with the real object,
//* controlling its access and adding extra functionality like caching, logging, and security checks.
//*******************************************************************************************

/**
* This program uses the Proxy design pattern to display images.
* 
* The ImageInterface is an interface with a display method for showing images. 
* This is implemented by the RealImage class.
* 
* RealImage is the actual object that loads and displays the image from disk using the Swing library.
* 
* ImageProxy is a placeholder for RealImage. It controls access to RealImage, creating it only when necessary. 
* It also uses RealImage's display method to show the image.
* 
* ImageViewerWithGUI is a class that demonstrates how to use ImageProxy. 
* It creates a GUI where users can enter an image file path and display the image.
* 
* The Proxy pattern is used here to control access to the resource-heavy RealImage.
* It's useful when you need to manage expensive resources like images, files, or network connections. 
* It can also add extra functionality like caching, logging, and security checks.
* 
* Components:
*  - ImageInterface: The common interface for RealImage and ImageProxy
*  - RealImage: The actual object that loads and displays the image
*  - ImageProxy: The placeholder that controls access to RealImage
*  - ImageViewerWithGUI: The class that uses ImageProxy to display images
*/



public class ImageViewerApp {
    public static void main(String[] args) throws Exception {
        new ImageViewerWithGUI();
    }
}
// Sample Image File Path
//"C:\Users\hakan\OneDrive\Resimler\Ekran Görüntüleri\Ekran görüntüsü 2023-12-30 175403.png"