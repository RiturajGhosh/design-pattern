package pattern.strategy.curse;

import pattern.strategy.interfaces.CurseStrategy;

public class ImperioCurse implements CurseStrategy {

    public static final String CURSE_NAME = "Imperio";

    @Override
    public void use() {
        System.out.println("Imperio");
    }

    @Override
    public String getName() {
        return CURSE_NAME;
    }
}
