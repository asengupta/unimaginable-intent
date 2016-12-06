package hello;

import hello.tokenRules.ArbitraryWordRule;
import hello.tokenRules.SpecificWordRule;
import hello.tokenRules.TokenRule;
import hello.tokenRules.TokenRules;

import java.util.List;

import static java.util.stream.StreamSupport.stream;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenEmitter {
    public List<TokenRule> run(String input) {
        TokenRules candidateRules = TokenRules.ALL_RULES();
        TokenisingState state = new TokenisingState(candidateRules);
        stream(new StringSpliterator(input), false).forEach(character -> {
            state.process(character);
        });
        return state.emittedRules();
    }

    private TokenRule word(String word) {
        return new SpecificWordRule(word);
    }
    private TokenRule anyWord() {
        return new ArbitraryWordRule();
    }
}
