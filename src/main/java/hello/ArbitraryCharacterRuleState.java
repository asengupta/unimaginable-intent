package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class ArbitraryCharacterRuleState implements CharacterRuleState {
    private CharacterMatcher matcher = new ArbitraryCharacterMatcher();

    @Override
    public boolean match(Character character) {
        boolean matches = matcher.run(character);
        System.out.println(matches ? "Matched: " + character : "Did not match with :" + character);
        return matches;
    }

    @Override
    public CharacterRuleState next() {
        return new ArbitraryCharacterRuleState();
    }
}
