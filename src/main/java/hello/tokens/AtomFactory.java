package hello.tokens;

import hello.tokenRules.ArbitraryWordRule;
import hello.tokenRules.AssignmentRule;
import hello.tokenRules.TokenRule;
import hello.tokenRules.WhitespaceRule;
import one.util.streamex.StreamEx;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by asengupta on 12/6/16.
 */
public class AtomFactory {
    public AtomFactory() {
    }

    private Atom reduced(List<TokenRule> tokenRules) {
        if (tokenRules.get(0).getClass() == ArbitraryWordRule.class) {
            String word = reducedToken(tokenRules);
            return new Word(word);
        }
        if (tokenRules.get(0).getClass() == WhitespaceRule.class) {
            String word = reducedToken(tokenRules);
            return new Whitespace(word);
        }

        if (tokenRules.get(0).getClass() == AssignmentRule.class) {
            String word = reducedToken(tokenRules);
            return new Assignment();
        }
        return new LineDelimiter();
    }

    private String reducedToken(List<TokenRule> tokenRules) {
        Function<TokenRule, String> tokenRuleStringFunction = tokenRule -> tokenRule.asString();
        Stream<String> stringStream = tokenRules.stream().map(tokenRuleStringFunction);
        List<String> collect = stringStream.collect(Collectors.toList());
        return build(collect.toArray());
    }

    private String build(Object[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public List<Atom> build(List<TokenRule> tokens) {
        return StreamEx.of(tokens.stream()).groupRuns((tokenRuleLeft, tokenRuleRight) ->
                (tokenRuleLeft.getClass() == ArbitraryWordRule.class && tokenRuleRight.getClass() == ArbitraryWordRule.class) ||
                        (tokenRuleLeft.getClass() == WhitespaceRule.class && tokenRuleRight.getClass() == WhitespaceRule.class))
                .map(tokenRules -> reduced(tokenRules))
                .collect(toList());
    }

    public List<Atom> clean(List<Atom> atoms) {
        return atoms.stream().filter(atom -> atom.getClass() != Whitespace.class).collect(Collectors.toList());
    }
}
