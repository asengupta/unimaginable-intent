package hello;

import java.util.stream.Stream;

/**
 * Created by asengupta on 11/11/16.
 */
public abstract class TokenRule {
    public abstract boolean match(Character character);

    public abstract TokenRules predict(Character character);
}
