package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class SpecificCharacterRuleState implements CharacterRuleState {
    private SpecificCharacterRuleState next;
    private CharacterMatcher matcher;

    public SpecificCharacterRuleState(SpecificCharacterRuleState next, Character expectedCharacter) {
        this.next = next;
        matcher = new SpecificCharacterMatcher(expectedCharacter);
    }

    @Override
    public boolean match(Character character) {
        boolean matches = matcher.run(character);
//        System.out.println(matches ? "Matched: " + character : "Did not match with :" + character);
        return matches;
    }

    @Override
    public CharacterRuleState next() {
        return next;
    }
}
