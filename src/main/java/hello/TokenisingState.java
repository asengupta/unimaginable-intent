package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.*;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenisingState {
    private TokenRules rules;
    private final List<TokenRule> sequentialRules;

    public TokenisingState(TokenRules rules) {
        this.rules = rules;
        sequentialRules = new ArrayList<>();
    }

    public TokenRules rules(Character character) {
        rules = rules(character, rules);
        return rules;
    }

    public TokenRules rules(Character character, TokenRules candidateRules) {
        Stream<TokenRule> matchingRulesStream = StreamSupport.stream(candidateRules.spliterator(), false)
                .filter(predictedRule -> predictedRule.match(character));
        Stream<TokenRule> matchingRulesStream2 = StreamSupport.stream(candidateRules.spliterator(), false)
                .filter(predictedRule -> predictedRule.match(character));

        sequentialRules.addAll(matchingRulesStream2.collect(Collectors.toList()));
        List<TokenRule> predictedRulesStream = matchingRulesStream
                .flatMap(filteredRule -> filteredRule.predict(character).stream())
                .collect(toList());

        if (predictedRulesStream.isEmpty()) throw new RuntimeException("No rules matched...terminating streaming!");
        return new TokenRules(predictedRulesStream);
    }

    public ESqlRules emittedRules() {
        return new ESqlRules(sequentialRules);
    }
}
