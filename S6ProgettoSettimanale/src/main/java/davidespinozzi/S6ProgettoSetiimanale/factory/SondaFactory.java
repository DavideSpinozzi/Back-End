package davidespinozzi.S6ProgettoSetiimanale.factory;

import davidespinozzi.S6ProgettoSetiimanale.observer.SondaObservable;

public class SondaFactory {
    public static SondaObservable createSonda(int idSonda, double latitudine, double longitudine) {
        return new SondaObservable(idSonda, latitudine, longitudine);
    }
}
