// GUI class to display the text characters using flyweight pattern

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TextEditorWithGUI {
    private CharacterFactory characterFactory = new CharacterFactory();
    private List<TextCharacter> textCharacters = new ArrayList<>();

    public TextEditorWithGUI() {
        JFrame frame = new JFrame("Text Editor Using Flyweight Pattern");
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
                String text = inputField.getText();
                createTextCharacters(text);
                displayTextCharacters(displayPanel,50);
            }
        });

        frame.add(inputField);
        frame.add(displayButton);
        frame.add(displayPanel);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    private void createTextCharacters(String text) {
        textCharacters.clear();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            textCharacters.add(characterFactory.getCharacter(c));
        }
    }

    private void displayTextCharacters(JPanel panel, int charsPerLine) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < textCharacters.size(); i++) {
            TextCharacter character = textCharacters.get(i);
            gbc.gridx = i % charsPerLine;
            gbc.gridy = i / charsPerLine;
            character.display(panel, gbc);
        }
        panel.revalidate();
        panel.repaint();
    }
}