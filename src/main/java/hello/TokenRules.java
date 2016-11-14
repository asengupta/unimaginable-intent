package hello;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenRules {
    private TokenRule[] rules;

    public TokenRules(TokenRule... rules) {
        this.rules = rules;
    }

    public TokenRules(List<TokenRule> injected) {
        this.rules = injected.toArray(new TokenRule[injected.size()]);
    }

    public Spliterator<TokenRule> spliterator() {
        return new TokenRuleSpliterator(rules);
    }

    public Stream<TokenRule> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
