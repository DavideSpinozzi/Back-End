package progettoSettimana1.classi;

import progettoSettimana1.classiAstratte.Media;
import progettoSettimana1.interfaccia.Brighter;
import progettoSettimana1.interfaccia.Darker;
import progettoSettimana1.interfaccia.LessLouder;
import progettoSettimana1.interfaccia.Louder;
import progettoSettimana1.interfaccia.Playable;

public class Video extends Media implements Playable , Brighter , Darker, Louder , LessLouder{

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata, volume, luminosita);
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
	public void aumentaLuminosita(int valore) {
        int nuovaLuminosita = getLuminosita() + valore;
        setLuminosita(nuovaLuminosita);
    }
    
    @Override
    public void abbassaLuminosita(int valore) {
        int nuovaLuminosita = getLuminosita() - valore;
        setLuminosita(nuovaLuminosita);
    }

	@Override
	public void play() {
		for (int i = 0; i <getDurata(); i++) {
			String asterischi = ripetiCarattere('*', getVolume());
			String puntiEsclamativi = ripetiCarattere('!', getLuminosita());
			System.out.println(getTitolo() + asterischi + puntiEsclamativi);
		}
	}

}