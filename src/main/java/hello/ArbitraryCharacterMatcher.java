package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class ArbitraryCharacterMatcher implements CharacterMatcher {
    @Override
    public boolean run(Character character) {
        return ' ' != character;
    }
}
