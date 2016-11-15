package hello;

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
}
