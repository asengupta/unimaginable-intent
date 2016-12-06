package hello.tokenRules;

/**
 * Created by asengupta on 11/11/16.
 */
public class ArithmeticOperatorRule extends TokenRule {
    private Character character;

    @Override
    public boolean match(Character character) {
        boolean matches = character.equals('+') || character.equals('-') || character.equals('/') || character.equals('*');
        if (matches) System.out.println("[ARITHMETIC OPERATOR] Matched a " + character);
        this.character = character;
        return matches;
    }

    @Override
    public TokenRules predict(Character character) {
        return TokenRules.ALL_RULES();
    }

    @Override
    public String asString() {
        return character.toString();
    }
}
