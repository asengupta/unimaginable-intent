package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.StreamSupport.stream;

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

    public TokenRules process(Character character) {
        rules = process(character, rules);
        return rules;
    }

    public TokenRules process(Character character, TokenRules candidateRules) {
        Stream<TokenRule> matchingRulesStream = stream(candidateRules.spliterator(), false)
                .filter(predictedRule -> predictedRule.match(character));
        Stream<TokenRule> matchingRulesStreamCopy = stream(candidateRules.spliterator(), false)
                .filter(predictedRule -> predictedRule.match(character));

        sequentialRules.addAll(matchingRulesStreamCopy.collect(toList()));
        List<TokenRule> predictedRulesStream = matchingRulesStream
                .flatMap(filteredRule -> filteredRule.predict(character).stream())
                .collect(toList());

        if (predictedRulesStream.isEmpty()) throw new RuntimeException("No process matched...terminating streaming!");
        return new TokenRules(predictedRulesStream);
    }

    public List<TokenRule> emittedRules() {
        return sequentialRules;
    }
}
