package hello;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * Created by asengupta on 11/11/16.
 */
public class ESqlRules {

    private final List<String> sanitisedTokens;

    public ESqlRules(String[] strings) {
        List<String> tokens = asList(strings);
        sanitisedTokens = StreamSupport.stream(tokens.spliterator(), false).filter(t -> !("".equals(t.trim()))).collect(Collectors.toList());
    }

    public List<String> asArray() {
        return sanitisedTokens;
    }
}
