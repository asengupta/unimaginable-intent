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
        String sample = "MOVE func-chain FROM source TO dest WHERE select-cond";
        ESqlRules tokens = new ESqlTokeniserPipeline().run(sample);
        assertThat(tokens.asArray().toArray()).isEqualTo(new String[] {"MOVE", "func-chain", "FROM", "source", "TO", "dest", "WHERE", "select-cond"});
    }
}

