package hello.tokens;

import hello.tokens.Atom;

/**
 * Created by asengupta on 12/6/16.
 */
public class Whitespace implements Atom {
    private String whitespace;

    public Whitespace(String whitespace) {
        this.whitespace = whitespace;
    }
}
