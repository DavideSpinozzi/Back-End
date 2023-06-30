package progettoSettimana1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import progettoSettimana1.classi.Audio;
import progettoSettimana1.classi.Immagini;
import progettoSettimana1.classi.Video;
import progettoSettimana1.classiAstratte.Media;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Audio> audioList = new ArrayList<>();
		List<Video> videoList = new ArrayList<>();
		List<Immagini> immaginiList = new ArrayList<>();
		int counter = 0;

		while (counter != 3) {
			System.out.println("Menu:");
			System.out.println("1: Crea il tuo media");
			System.out.println("2: Scegli media da far riprodurre");
			System.out.println("3: Esci");

			counter = scanner.nextInt();

			switch (counter) {
			case 1:
				System.out.println();
				System.out.println("Crea media:");
				System.out.println("1: Audio");
				System.out.println("2: Video");
				System.out.println("3: Immagini");

				int tipoOggetto = scanner.nextInt();

				switch (tipoOggetto) {
				case 1:
					System.out.println();
					System.out.println("Inserisci il titolo: ");
					String titoloAudio = scanner.next();
					System.out.println("Inserisci la durata: ");
					int durataAudio = scanner.nextInt();
					System.out.println("Inserisci il volume: ");
					int volumeAudio = scanner.nextInt();
					audioList.add(new Audio(titoloAudio, durataAudio, volumeAudio));
					System.out.println("Audio creato");
					System.out.println();
					break;
				case 2:
					System.out.println();
					System.out.println("Inserisci il titolo: ");
					String titoloVideo = scanner.next();
					System.out.println("Inserisci la durata: ");
					int durataVideo = scanner.nextInt();
					System.out.println("Inserisci il volume: ");
					int volumeVideo = scanner.nextInt();
					System.out.println("Inserisci la luminosita: ");
					int luminositaVideo = scanner.nextInt();
					videoList.add(new Video(titoloVideo, durataVideo, volumeVideo, luminositaVideo));
					System.out.println("Video creato");
					System.out.println();
					break;
				case 3:
					System.out.println();
					System.out.println("Inserisci il titolo: ");
					String titoloImmagini = scanner.next();
					System.out.println("Inserisci la luminosita: ");
					int luminositaImmagini = scanner.nextInt();
					immaginiList.add(new Immagini(titoloImmagini, luminositaImmagini));
					System.out.println("Immagine creata");
					System.out.println();
					break;
				default:
					System.out.println("Scelta non valida");
					break;
				}

				break;
			case 2:
				System.out.println("Lista dei media presenti:");
				for (Audio audio : audioList) {
					System.out.println("Audio: " + audio.getTitolo());
				}
				for (Video video : videoList) {
					System.out.println("Video: " + video.getTitolo());
				}
				for (Immagini immagini : immaginiList) {
					System.out.println("Immagine: " + immagini.getTitolo());
				}

				System.out.print("Inserisci il titolo del media da riprodurre: ");
				String titoloOggetto = scanner.next();
				Media oggettoDaVisualizzare = null;
				for (Audio audio : audioList) {
					if (audio.getTitolo().equals(titoloOggetto)) {
						oggettoDaVisualizzare = audio;
						break;
					}
				}
				if (oggettoDaVisualizzare == null) {
					for (Video video : videoList) {
						if (video.getTitolo().equals(titoloOggetto)) {
							oggettoDaVisualizzare = video;
							break;
						}
					}
				}
				if (oggettoDaVisualizzare == null) {
					for (Immagini immagini : immaginiList) {
						if (immagini.getTitolo().equals(titoloOggetto)) {
							oggettoDaVisualizzare = immagini;
							break;
						}
					}
				}

				if (oggettoDaVisualizzare != null) {
				    if (oggettoDaVisualizzare instanceof Immagini) {
				        Immagini oggetto = (Immagini) oggettoDaVisualizzare;
				        oggetto.show();
				    } else if (oggettoDaVisualizzare instanceof Audio) {
				        Audio oggetto = (Audio) oggettoDaVisualizzare;
				        oggetto.play();
				    } else if (oggettoDaVisualizzare instanceof Video) {
				        Video oggetto = (Video) oggettoDaVisualizzare;
				        oggetto.play();
				    }
				} else {
				    System.out.println("Nessun media trovato con il titolo specificato");
				}

				break;
			case 3:
				System.out.println("Uscita...");
				counter = 3;
				break;
			default:
				System.out.println("Scelta non valida");
				break;
			}

		}

		scanner.close();
	}
}