package hello;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * Created by asengupta on 11/11/16.
 */
public class ESqlRules {
    private List<TokenRule> tokenRules;

    public ESqlRules(List<TokenRule> tokenRules) {
        this.tokenRules = tokenRules;
    }

    @Override
    public String toString() {
        return "ESqlRules{" +
                "tokenRules=" + tokenRules +
                '}';
    }
}
