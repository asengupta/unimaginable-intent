package hello.tokenRules;

import hello.tokenRules.TokenRule;
import hello.tokenRules.TokenRules;

/**
 * Created by asengupta on 11/15/16.
 */
public class LineDelimiterRule extends TokenRule {
    @Override
    public boolean match(Character character) {
        boolean equals = character.equals(';');
        if (equals) System.out.println("[LINE DELIMITER] Matched a " + character);
        return equals;
    }

    @Override
    public TokenRules predict(Character character) {
        return TokenRules.ALL_RULES();
    }

    @Override
    public String asString() {
        return ";";
    }
}
