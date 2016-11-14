package hello;

/**
 * Created by asengupta on 11/11/16.
 */
public class WhitespaceRule extends TokenRule {
    @Override
    public boolean match(Character character) {
        boolean matches = character.equals(' ');
        if (matches) System.out.println("Matched a space");
        return matches;
    }

    @Override
    public TokenRules predict(Character character) {
        return new TokenRules(new WordRule("MOVE"), new WhitespaceRule());
    }
}
