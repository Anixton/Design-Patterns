// GUI class to display images using Proxy pattern

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageViewerWithGUI {
    
    public ImageViewerWithGUI() {
        JFrame frame = new JFrame("Image Viewer Using Proxy Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(50);
        JButton displayButton = new JButton("Enter");

        JPanel displayPanel = new JPanel();

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayButton.doClick();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imageFileName = inputField.getText();
                displayImage(displayPanel, imageFileName);
            }
        });

        frame.add(inputField);
        frame.add(displayButton);
        frame.add(displayPanel);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private void displayImage(JPanel panel, String imageFileName) {
        imageFileName = cleanFilePath(imageFileName);
        setPanel(panel);
        createAndDisplayImageProxy(panel, imageFileName);
        createScaledImageAndDisplay(panel, imageFileName);
    }

    private String cleanFilePath(String imageFileName) {
        if (imageFileName.startsWith("\"")) {
            imageFileName = imageFileName.substring(1);
        }
        if (imageFileName.endsWith("\"")) {
            imageFileName = imageFileName.substring(0, imageFileName.length() - 1);
        }
        return imageFileName;
    }

    private void setPanel(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
    }

    private void createAndDisplayImageProxy(JPanel panel, String imageFileName) {
        ImageProxy imageProxy = new ImageProxy(imageFileName);
        imageProxy.display(panel, imageFileName);
    }

    private void createScaledImageAndDisplay(JPanel panel, String imageFileName) {
        ImageIcon imageIcon = new ImageIcon(imageFileName);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(imageIcon);  

        panel.add(imageLabel);
        panel.setVisible(true);
    }
}
