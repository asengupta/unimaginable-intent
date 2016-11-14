package hello;

/**
 * Created by asengupta on 11/14/16.
 */
public interface CharacterRuleState {
    boolean match(Character character);

    CharacterRuleState next();
}
