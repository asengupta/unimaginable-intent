package hello;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.*;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenisingState {
    private TokenRules rules;

    public TokenisingState(TokenRules rules) {
        this.rules = rules;
    }

    public TokenRules rules(Character character) {
        rules = rules(character, rules);
        return rules;
    }

    public TokenRules rules(Character character, TokenRules predictedRules) {
        Stream<TokenRule> tokenRuleStream = StreamSupport.stream(predictedRules.spliterator(), false)
                .filter(predictedRule -> predictedRule.match(character));
        List<TokenRule> matchingRules = tokenRuleStream
                .flatMap(filteredRule -> filteredRule.predict(character).stream())
                .collect(toList());

        if (matchingRules.isEmpty()) throw new RuntimeException("No rules matched...terminating streaming!");
        return new TokenRules(matchingRules);
    }
}
