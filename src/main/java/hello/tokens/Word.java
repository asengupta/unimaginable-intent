package hello.tokens;

import hello.tokens.Atom;

/**
 * Created by asengupta on 12/6/16.
 */
public class Word implements Atom {
    private String word;

    public Word(String word) {
        this.word = word;
    }
}
