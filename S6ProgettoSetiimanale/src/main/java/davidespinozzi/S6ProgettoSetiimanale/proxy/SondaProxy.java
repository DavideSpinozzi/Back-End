package davidespinozzi.S6ProgettoSetiimanale.proxy;

public class SondaProxy implements ComunicazioneSonda {
    private String baseUrl;

    public SondaProxy(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public void sendAlarm(int idSonda, double latitudine, double longitudine, int smokeLevel) {
        if (smokeLevel > 5) {
            String alarmUrl = baseUrl + "/alarm?idsonda=" + idSonda +
                              "&lat=" + latitudine +
                              "&lon=" + longitudine +
                              "&smokelevel=" + smokeLevel;

            System.out.println("Allarme via Proxy: " + alarmUrl);
        } else {
            System.out.println("Livello di fumo basso, nessun allarme inviato.");
        }
    }
}
