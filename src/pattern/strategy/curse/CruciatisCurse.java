package pattern.strategy.curse;

import pattern.strategy.interfaces.CurseStrategy;

public class CruciatisCurse implements CurseStrategy {

    public static final String CURSE_NAME = "Cruciatis";

    @Override
    public void use() {
        System.out.println("CRUCIO");
    }

    @Override
    public String getName() {
        return CURSE_NAME;
    }
}
