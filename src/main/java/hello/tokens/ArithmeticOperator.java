package hello.tokens;

/**
 * Created by asengupta on 12/6/16.
 */
public class ArithmeticOperator {
    public static Atom operator(String word) {
        if ("+".equals(word)) return new Plus();
        if ("-".equals(word)) return new Minus();
        if ("*".equals(word)) return new Into();
        if ("/".equals(word)) return new By();
        throw new RuntimeException("The character [" + word + "] could not be rocognised but slipped through token rule matching.");
    }
}
