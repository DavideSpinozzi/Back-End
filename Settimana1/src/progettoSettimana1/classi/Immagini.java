package progettoSettimana1.classi;

import progettoSettimana1.classiAstratte.Media;
import progettoSettimana1.interfaccia.Brighter;
import progettoSettimana1.interfaccia.Darker;
import progettoSettimana1.interfaccia.Showable;

public class Immagini extends Media implements Showable, Brighter, Darker{
    
 public Immagini(String titolo, int luminosita) {
	 super(titolo,luminosita);
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
public void show() {
	String asterischi = ripetiCarattere('*',getLuminosita());
	System.out.println(getTitolo() + asterischi);
}

}