package hello;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenRules {
    public static TokenRules ALL_RULES() {
        return new TokenRules(new LineDelimiterRule(), new WhitespaceRule(), new ArbitraryWordRule());
    }

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

    public Collection<TokenRule> asList() {
        return Arrays.asList(rules);
    }
}
