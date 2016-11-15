package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public class ArbitraryWordRule extends TokenRule {
    private CharacterRuleState currentState = new ArbitraryCharacterRuleState();
    private Character character;

    public ArbitraryWordRule(Character character) {
        this.character = character;
    }

    public ArbitraryWordRule() {
        this('∫');
    }

    @Override
    public boolean match(Character character) {
        boolean match = currentState.match(character);
        if (match) this.character = character;
        if (match) System.out.println("[ARBITRARY WORD] Matched a " + character);
        return match;
    }

    @Override
    public TokenRules predict(Character character) {
        return new TokenRules(new ArbitraryWordRule(character), new WhitespaceRule(), new LineDelimiterRule());
    }

    @Override
    public String toString() {
        return "ArbitraryWordRule{" +
                "character=" + character +
                '}';
    }
}
