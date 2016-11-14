package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class CharacterRuleState {
    private CharacterRuleState next;
    private CharacterMatcher matcher;

    public CharacterRuleState(CharacterRuleState next, Character expectedCharacter) {
        this.next = next;
        matcher = new SpecificCharacterMatcher(expectedCharacter);
    }

    public boolean match(Character character) {
        boolean matches = matcher.run(character);
        System.out.println(matches ? "Matched: " + character : "Did not match with :" + character);
        return matches;
    }

    public CharacterRuleState next() {
        return next;
    }
}
