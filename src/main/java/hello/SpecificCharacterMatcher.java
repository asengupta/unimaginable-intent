package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class SpecificCharacterMatcher implements CharacterMatcher {
    private Character c;

    public SpecificCharacterMatcher(Character c) {
        this.c = c;
    }

    @Override
    public boolean run(Character character) {
        return c.equals(character);
    }
}
