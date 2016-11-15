package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class SpecificWordRule extends TokenRule {

    private CharacterRuleState currentState;

    public SpecificWordRule(String word) {
        currentState = nextRule(0, word.toCharArray());
    }

    private SpecificCharacterRuleState nextRule(int index, char[] characters) {
        if (index == characters.length - 1) return new SpecificCharacterRuleState(null, characters[index]);
        return new SpecificCharacterRuleState(nextRule(index + 1, characters), characters[index]);
    }

    @Override
    public boolean match(Character character) {
        boolean match = currentState.match(character);
        if (match) System.out.println("[SPECIFIC WORD] Matched a " + character);
        return match;
    }

    @Override
    public TokenRules predict(Character character) {
        currentState = currentState.next();
        if (currentState == null) return new TokenRules(new WhitespaceRule());
        return new TokenRules(this);
    }
}
