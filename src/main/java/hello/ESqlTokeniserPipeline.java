package hello;

import java.util.stream.StreamSupport;

/**
 * Created by asengupta on 11/11/16.
 */
public class ESqlTokeniserPipeline {
    public ESqlRules run(String input) {
        TokenRules candidateRules = new TokenRules(word("MOVE"));
        TokenisingState state = new TokenisingState(candidateRules);
        StreamSupport.stream(new StringSpliterator(input), false).forEach(character -> {
            state.rules(character);
        });
        return new ESqlRules(input.split(" "));
    }

    private WordRule word(String word) {
        return new WordRule(word);
    }
}
