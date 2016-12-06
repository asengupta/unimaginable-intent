package hello.tokenRules;

import hello.tokenRules.TokenRule;
import hello.tokenRules.TokenRules;

/**
 * Created by asengupta on 11/11/16.
 */
public class WhitespaceRule extends TokenRule {
    @Override
    public boolean match(Character character) {
        boolean matches = character.equals(' ');
        if (matches) System.out.println("[WHITESPACE] Matched a space");
        return matches;
    }

    @Override
    public TokenRules predict(Character character) {
        return TokenRules.ALL_RULES();
    }

    @Override
    public String asString() {
        return " ";
    }
}
