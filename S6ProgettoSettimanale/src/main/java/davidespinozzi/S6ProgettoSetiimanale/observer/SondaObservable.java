package davidespinozzi.S6ProgettoSetiimanale.observer;

import java.util.ArrayList;
import java.util.List;

public class SondaObservable {
    private List<ControlloObserver> observers = new ArrayList<>();
    private int idSonda;
    private double latitudine;
    private double longitudine;
    private int smokeLevel;

    public SondaObservable(int idSonda, double latitudine, double longitudine) {
        this.idSonda = idSonda;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public void addObserver(ControlloObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ControlloObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ControlloObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setSmokeLevel(int smokeLevel) {
        this.smokeLevel = smokeLevel;
        if (smokeLevel > 5) {
            notifyObservers();
        }
    }

    public int getIdSonda() {
        return idSonda;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public int getSmokeLevel() {
        return smokeLevel;
    }
}
