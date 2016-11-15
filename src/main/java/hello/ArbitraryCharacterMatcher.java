package hello;

import java.util.regex.Pattern;

/**
 * Created by asengupta on 11/14/16.
 */
public class ArbitraryCharacterMatcher implements CharacterMatcher {
    @Override
    public boolean run(Character character) {
        return Pattern.compile("[A-Za-z0-9_\\-\\+]+").matcher("" + character).matches();
    }
}
