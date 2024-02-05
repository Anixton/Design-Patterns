// Concrete Flyweight

import javax.swing.*;
import java.awt.*;

class ConcreteCharacter implements TextCharacter {
    private char character;

    public ConcreteCharacter(char character) {
        this.character = character;
    }

    @Override
    public void display(JPanel panel, GridBagConstraints constraints) {
        JLabel label = new JLabel(String.valueOf(character));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Set the border to an empty border with no padding
        panel.add(label, constraints);

        // Customizing font
        Font customFont = new Font("Consolas", Font.PLAIN, 15); 
        label.setFont(customFont);
    }
}
