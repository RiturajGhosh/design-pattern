import pattern.obeserver.displaydevice.CurrentConditionDisplay;
import pattern.obeserver.displaydevice.StatisticsDisplay;
import pattern.obeserver.interfaces.Observer;
import pattern.obeserver.subject.WeatherDataEmitter;
import pattern.strategy.curse.CruciatisCurse;
import pattern.strategy.curse.ImperioCurse;
import pattern.strategy.curse.KillingCurse;
import pattern.strategy.interfaces.Wizard;
import pattern.strategy.wizard.DefenceAgainstDarkArts;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //strategy pattern
        Wizard wizard = new DefenceAgainstDarkArts(Arrays.asList(new CruciatisCurse(),
                new ImperioCurse(),
                new KillingCurse()));
        wizard.spellCurse(ImperioCurse.CURSE_NAME);

        //observer pattern
        WeatherDataEmitter weatherData = new WeatherDataEmitter();
        Observer currentDisplay = new CurrentConditionDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        weatherData.setAttributes(30.42, 34.34, 90.2);
        weatherData.removeObserver(statisticsDisplay);
        weatherData.setAttributes(35.42, 34.34, 98.2);
    }
}
