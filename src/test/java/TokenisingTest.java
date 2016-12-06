import hello.Atom;
import hello.AtomFactory;
import hello.TokenEmitter;
import hello.TokenRule;
import org.junit.Test;

import java.util.List;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenisingTest {
    @Test
    public void canPredictMoveRule() {
        String sample = "  MOVE    func_chain FROM    source TO    dest WHERE select_cond;";
        List<TokenRule> tokens = new TokenEmitter().run(sample);
        System.out.println(tokens);
        List<Atom> atoms = new AtomFactory().build(tokens);
        System.out.println(atoms);
    }
}

