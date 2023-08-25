package davidespinozzi.S6ProgettoSetiimanale.observer;

public class CentroControllo implements ControlloObserver {
    private String baseUrl;

    public CentroControllo(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public void update(SondaObservable sonda) {
        String alarmUrl = baseUrl + "/alarm?idsonda=" +
                          sonda.getIdSonda() + "&lat=" +
                          sonda.getLatitudine() + "&lon=" +
                          sonda.getLongitudine() + "&smokelevel=" +
                          sonda.getSmokeLevel();

        System.out.println("Invio allarme: " + alarmUrl);
    }
}
