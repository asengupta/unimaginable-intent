package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Created by asengupta on 11/11/16.
 */
public class ESqlTokeniserPipeline {
    public ESqlRules run(String input) {
        TokenRules candidateRules = TokenRules.ALL_RULES();
        TokenisingState state = new TokenisingState(candidateRules);
        StreamSupport.stream(new StringSpliterator(input), false).forEach(character -> {
            state.rules(character);
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
