package hello.tokenRules;

/**
 * Created by asengupta on 12/6/16.
 */
public class AssignmentRule extends TokenRule {
    @Override
    public boolean match(Character character) {
        boolean equals = character.equals('=');
        if (equals) System.out.println("[ASSIGNMENT] Matched a " + character);
        return equals;
    }

    @Override
    public TokenRules predict(Character character) {
        return TokenRules.ALL_RULES();
    }

    @Override
    public String asString() {
        return "=";
    }
}
