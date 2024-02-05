// Flyweight Factory

import java.util.HashMap;
import java.util.Map;

class CharacterFactory {
    private Map<Character, TextCharacter> characters = new HashMap<>();

    public TextCharacter getCharacter(char character) {
        if (!characters.containsKey(character)) {
            characters.put(character, new ConcreteCharacter(character));
        }
        return characters.get(character);
    }
}