package hello;

import hello.tokenRules.TokenRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RandomStuff<String> ofString() {
        return new RandomStuff<>("ofString");
    }

    @Bean
    public RandomStuff<TokenRule> ofTokenRule() {
        return new RandomStuff<>("ofTokenRule");
    }
}