package hello.pipeline;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by asengupta on 11/11/16.
 */
public class StringSpliterator implements Spliterator<Character> {
    private int pointer;
    private String s;

    public StringSpliterator(String s) {
        pointer = 0;
        this.s = s;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        if (pointer > s.length() - 1) return false;
        action.accept(s.toCharArray()[pointer++]);
        return true;
    }

    @Override
    public Spliterator<Character> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return s.length();
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
