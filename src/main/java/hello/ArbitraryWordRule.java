package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class ArbitraryWordRule extends TokenRule {

    private CharacterRuleState currentState = new ArbitraryCharacterRuleState();

    @Override
    public boolean match(Character character) {
        return currentState.match(character);
    }

    @Override
    public TokenRules predict(Character character) {
        return new TokenRules(this, new WhitespaceRule());
    }
}
