package hello;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by asengupta on 12/6/16.
 */
public class AtomFactory {
    public AtomFactory() {
    }

    public Atom build(List<TokenRule> tokenRules) {
        if (tokenRules.get(0).getClass() == ArbitraryWordRule.class) {
            Function<TokenRule, String> tokenRuleStringFunction = tokenRule -> tokenRule.asString();
            Stream<String> stringStream = tokenRules.stream().map(tokenRuleStringFunction);
            List<String> collect = stringStream.collect(Collectors.toList());
            String word = build(collect.toArray());
            return new Word(word);
        }
        if (tokenRules.get(0).getClass() == WhitespaceRule.class) {
            Function<TokenRule, String> tokenRuleStringFunction = tokenRule -> tokenRule.asString();
            Stream<String> stringStream = tokenRules.stream().map(tokenRuleStringFunction);
            List<String> collect = stringStream.collect(Collectors.toList());
            String word = build(collect.toArray());
            return new Whitespace(word);
        }
        return new LineDelimiter();
    }

    private String build(Object[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
