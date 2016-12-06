import hello.tokens.Atom;
import hello.tokens.AtomFactory;
import hello.TokenEmitter;
import hello.tokenRules.TokenRule;
import org.junit.Test;

import java.util.List;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenisingTest {
    @Test
    public void canPredictMoveRule() {
        String sample = " x=(1+2);";
        List<TokenRule> tokens = new TokenEmitter().run(sample);
        System.out.println(tokens);
        List<Atom> atoms = new AtomFactory().build(tokens);
        atoms = new AtomFactory().clean(atoms);
        System.out.println(atoms);
    }
}

