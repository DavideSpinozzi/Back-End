package progettoSettimana1.classi;

import progettoSettimana1.classiAstratte.Media;
import progettoSettimana1.interfaccia.LessLouder;
import progettoSettimana1.interfaccia.Louder;
import progettoSettimana1.interfaccia.Playable;

public class Audio extends Media implements Playable, Louder , LessLouder{
    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);
    }
    
    @Override
	public void alzaVolume(int valore) {
        int nuovoVolume = getVolume() + valore;
        setVolume(nuovoVolume);
    }
    
    @Override
    public void abbassaVolume(int valore) {
        int nuovoVolume = getVolume() - valore;
        setVolume(nuovoVolume);
    }

	@Override
	public void play() {
		for (int i = 0; i < getDurata(); i++) {
			String asterischi = ripetiCarattere('*', getVolume());
			System.out.println(getTitolo() + asterischi);
		}
	}

}