package pattern.obeserver.displaydevice;

import pattern.obeserver.dto.EventData;
import pattern.obeserver.interfaces.DisplayDevice;
import pattern.obeserver.interfaces.Observable;
import pattern.obeserver.interfaces.Observer;

public class StatisticsDisplay implements DisplayDevice, Observer {

    private final Observable observable;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display(EventData data) {
        System.out.printf("Statistics temp: %s, " +
                        "humidity: %s, pressure: %s%n",
                data.getTemperature(),
                data.getHumidity(),
                data.getPressure());
    }

    @Override
    public void executeUpdate(EventData data) {
        this.display(data);
    }
}
