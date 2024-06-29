package pattern.obeserver.subject;

import pattern.obeserver.dto.EventData;
import pattern.obeserver.interfaces.Observable;
import pattern.obeserver.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataEmitter implements Observable {

    private double temperature;
    private double humidity;
    private double pressure;
    private List<Observer> observerList;

    public WeatherDataEmitter() {
        this.setObserverList(new ArrayList<>());
    }

    public WeatherDataEmitter(double temperature,
                              double humidity,
                              double pressure) {
        this(temperature, humidity, pressure, new ArrayList<>());
    }

    private WeatherDataEmitter(double temperature,
                               double humidity,
                               double pressure,
                               List<Observer> observerList) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.observerList = observerList;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer ->
                observer.executeUpdate(new EventData(temperature,
                        humidity, pressure)));
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        var index = this.observerList.indexOf(observer);
        if (index >= 0) {
            this.observerList.remove(index);
        }
    }

    private void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public void setAttributes(double temperature,
                              double humidity,
                              double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
