import hello.tokens.Atom;
import hello.tokens.AtomFactory;
import hello.pipeline.TokenEmitter;
import hello.tokenRules.TokenRule;
import hello.tokens.ParseRule;
import org.junit.Test;

import java.util.List;

/**
 * Created by asengupta on 11/11/16.
 */
public class TokenisingTest {
    @Test
    public void canPredictMoveRule() {
        String sample = " 3+(1   +   2)   ;";
        List<TokenRule> tokens = new TokenEmitter().run(sample);
        System.out.println(tokens);
        List<Atom> atoms = new AtomFactory().build(tokens);
        atoms = new AtomFactory().clean(atoms);
        System.out.println(atoms);
        expression();
    }

    private ParseRule expression() {
        return parenthesizedExpression().or(baldExpression());
    }

    private ParseRule baldExpression() {
        return unitaryExpression().or(binaryExpression());
    }

    private ParseRule binaryExpression() {
        return expression().then(operator()).then(expression());
    }

    private ParseRule unitaryExpression() {
        return number();
    }

    private ParseRule number() {
        return null;
    }

    private ParseRule operator() {
        return null;
    }

    private ParseRule parenthesizedExpression() {
        return openingParenthesis().then(expression()).then(closingParenthesis());
    }

    private ParseRule closingParenthesis() {
        return null;
    }

    private ParseRule openingParenthesis() {
        return null;
    }
}

