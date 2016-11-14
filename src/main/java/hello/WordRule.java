package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class WordRule extends TokenRule {

    private CharacterRuleState currentState;

    public WordRule(String word) {
        currentState = nextRule(0, word.toCharArray());
    }

    private CharacterRuleState nextRule(int index, char[] characters) {
        if (index == characters.length - 1) return new CharacterRuleState(null, characters[index]);
        return new CharacterRuleState(nextRule(index + 1, characters), characters[index]);
    }

    @Override
    public boolean match(Character character) {
        return currentState.match(character);
    }

    @Override
    public TokenRules predict(Character character) {
        currentState = currentState.next();
        if (currentState == null) return new TokenRules(new WhitespaceRule());
        return new TokenRules(this);
    }
}
