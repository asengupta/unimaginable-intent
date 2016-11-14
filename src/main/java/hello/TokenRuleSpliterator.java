package hello;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenRuleSpliterator implements Spliterator<TokenRule> {
    private TokenRule[] rules;
    int pointer = 0;

    public TokenRuleSpliterator(TokenRule[] rules) {
        this.rules = rules;
    }

    @Override
    public boolean tryAdvance(Consumer<? super TokenRule> action) {
        if (pointer > rules.length - 1) return false;
        action.accept(rules[pointer ++]);
        return true;
    }

    @Override
    public Spliterator<TokenRule> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
