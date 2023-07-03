package esercizio3;

	public class Banca {
	    public static void main(String args[]) {
	        ContoCorrente conto1 = new ContoCorrente("Giovanni Ok", 200500);

	        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

	        try {
	            conto1.preleva(1750.5);
	            System.out.println("Saldo conto: " + conto1.restituisciSaldo());
	        } catch (BancaException e) {
	            System.out.println("Errore durante il prelievo: " + e);
	            e.printStackTrace();
	        }

	        ContoOnLine conto2 = new ContoOnLine("Aldo Ok", 700000, 1500);

	        conto2.stampaSaldo();

	        try {
	            conto2.preleva(2000);
	            conto2.stampaSaldo();
	        } catch (BancaException e) {
	            System.out.println("Errore durante il prelievo: " + e);
	            e.printStackTrace();
	        }
	    }
	}
	