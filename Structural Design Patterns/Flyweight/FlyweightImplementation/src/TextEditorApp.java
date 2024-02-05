//*******************************************************************************************
//*  Hakan Gezginci
//* 
//*  This application demonstrates the Flyweight design pattern, which is used to manage
//*  large numbers of similar objects more efficiently. The pattern achieves this by sharing
//*  the common state of the objects, reducing the memory footprint and potentially improving
//*  the performance of the application.
//*******************************************************************************************

/**
* 
*  The TextCharacter interface defines the method for displaying the text characters, which
*  are implemented by the ConcreteCharacter class. The ConcreteCharacter class represents
*  the flyweight object, which stores the intrinsic state of the text character, such as the
*  character itself, and the extrinsic state, such as the count of the character. The
*  ConcreteCharacter class implements the display method to render the text character on the
*  panel using the Swing library.
*
*  The CharacterFactory class serves as the flyweight factory, which creates and manages the
*  flyweight objects. The factory maintains a map of characters and their corresponding
*  flyweight objects, and provides a method to retrieve the flyweight object for a given
*  character. If the flyweight object does not exist, the factory creates a new one and adds
*  it to the map.
*
*  The TextEditorWithGUI class demonstrates the usage of the flyweight pattern to display a
*  large number of text characters on a panel. The class creates a GUI with an input field
*  and a display button, allowing the user to enter a text and display the characters on the
*  panel. The class uses the CharacterFactory to create and manage the flyweight objects, and
*  the TextCharacter interface to display the text characters on the panel.
*
*  The flyweight pattern provides a memory-efficient solution for managing a large number of
*  similar objects, by sharing the common state and reducing the memory footprint. The
*  pattern is particularly useful for applications that require the creation of a large
*  number of objects with similar properties, such as text editors, graphical user interfaces,
*  and games.
*
*  Components:
*  - Flyweight: TextCharacter
*  - Concrete Flyweight: ConcreteCharacter
*  - Flyweight Factory: CharacterFactory
*  - Client Code: TextEditorWithGUI
*/

import javax.swing.SwingUtilities;

    public class TextEditorApp {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new TextEditorWithGUI();
                }
            });
    }
}
