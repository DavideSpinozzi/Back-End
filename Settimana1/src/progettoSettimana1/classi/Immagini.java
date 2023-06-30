package progettoSettimana1.classi;

import progettoSettimana1.classiAstratte.Media;
import progettoSettimana1.interfaccia.Showable;

public class Immagini extends Media implements Showable{
    
 public Immagini(String titolo, int luminosita) {
	 super(titolo,luminosita);
 }

public void aumentaLuminosita(int valore) {
    int nuovaLuminosita = getLuminosita() + valore;
    setLuminosita(nuovaLuminosita);
}

public void abbassaLuminosita(int valore) {
    int nuovaLuminosita = getLuminosita() - valore;
    setLuminosita(nuovaLuminosita);
}

@Override
public void show() {
	String asterischi = ripetiCarattere('*',getLuminosita());
	System.out.println(getTitolo() + asterischi);
}

}