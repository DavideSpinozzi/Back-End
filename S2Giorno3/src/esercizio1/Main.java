package esercizio1;

public class Main {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new stampaCarattere("*"));
        Thread thread2 = new Thread(new stampaCarattere("#"));
        
        thread1.start();
        thread2.start();
    }
}

class stampaCarattere implements Runnable {
    private String carattere;
    
    public stampaCarattere(String carattere) {
        this.carattere = carattere;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(carattere);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}