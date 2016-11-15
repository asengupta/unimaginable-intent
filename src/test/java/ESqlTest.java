import hello.ESqlTokeniserPipeline;
import hello.ESqlRules;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by asengupta on 11/11/16.
 */
public class ESqlTest {
    @Test
    public void canPredictMoveRule() {
        String sample = "MOVE func_chain FROM source TO dest WHERE select_cond;";
        ESqlRules tokens = new ESqlTokeniserPipeline().run(sample);
        System.out.println(tokens);
//        assertThat(tokens.asArray().toArray()).isEqualTo(new String[] {"MOVE", "func-chain", "FROM", "source", "TO", "dest", "WHERE", "select-cond"});

    }
}

