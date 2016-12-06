import hello.*;
import one.util.streamex.StreamEx;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by asengupta on 11/11/16.
 */
public class ESqlTest {
    @Test
    public void canPredictMoveRule() {
        String sample = "  MOVE    func_chain FROM    source TO    dest WHERE select_cond;";
        ESqlRules tokens = new ESqlTokeniserPipeline().run(sample);
        System.out.println(tokens);
        List<Atom> atoms = StreamEx.of(tokens.stream()).groupRuns((tokenRuleLeft, tokenRuleRight) ->
                (tokenRuleLeft.getClass() == ArbitraryWordRule.class && tokenRuleRight.getClass() == ArbitraryWordRule.class) ||
                        (tokenRuleLeft.getClass() == WhitespaceRule.class && tokenRuleRight.getClass() == WhitespaceRule.class))
                .map(tokenRules -> new AtomFactory().build(tokenRules))
                .collect(toList());

        System.out.println(atoms);
    }
}

