package pattern.strategy.wizard;

import pattern.strategy.interfaces.CurseStrategy;
import pattern.strategy.interfaces.Wizard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class DefenceAgainstDarkArts implements Wizard {

    private final Map<String, CurseStrategy> curseStrategiesByName;

    public final List<CurseStrategy> curseStrategyList;

    public DefenceAgainstDarkArts(List<CurseStrategy> curseStrategyList) {
        this.curseStrategyList = curseStrategyList;
        this.curseStrategiesByName = populateMap(this.curseStrategyList);
    }

    private Map<String, CurseStrategy> populateMap(List<CurseStrategy>
                                                           curseStrategyList) {
        var curseByName = new HashMap<String, CurseStrategy>();
        curseStrategyList
                .forEach(curseStrategy ->
                        curseByName.put(curseStrategy.getName(), curseStrategy));
        return curseByName;
    }

    @Override
    public void spellCurse(String curseName) {
        var curse = curseStrategiesByName.get(curseName);
        if (null == curse) {
            throw new NoSuchElementException();
        }
        curse.use();
    }
}
