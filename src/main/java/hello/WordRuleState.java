package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class WordRuleState {
    private WordRuleState next;
    private Character expectedCharacter;

    public WordRuleState(WordRuleState next, Character expectedCharacter) {
        this.next = next;
        this.expectedCharacter = expectedCharacter;
    }

    public boolean match(Character character) {
        boolean matches = expectedCharacter.equals(character);
        System.out.println(matches ? "Matched: " + character : "Did not match with :" + character);
        return matches;
    }

    public WordRuleState next() {
        return next;
    }
}
