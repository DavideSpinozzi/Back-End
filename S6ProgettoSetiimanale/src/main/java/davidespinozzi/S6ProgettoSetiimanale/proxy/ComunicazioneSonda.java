package davidespinozzi.S6ProgettoSetiimanale.proxy;

public interface ComunicazioneSonda {
    void sendAlarm(int idSonda, double latitudine, double longitudine, int smokeLevel);
}
