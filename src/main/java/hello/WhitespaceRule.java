package hello;

import java.util.List;

/**
 * Created by asengupta on 11/11/16.
 */
public class WhitespaceRule extends TokenRule {
    @Override
    public boolean match(Character character) {
        return character.equals(' ');
    }

    @Override
    public TokenRules predict(Character character) {
        return new TokenRules(new WordRule("MOVE"), new WhitespaceRule());
    }
}
