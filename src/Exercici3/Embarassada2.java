package Exercici3;

import java.util.concurrent.Semaphore;

public class Embarassada2 extends Thread {
    private final int id;
    private final int tempsEspera;
    private final Semaphore semaphore;

    public Embarassada2(int id, Semaphore semaphore) {
        this.id = id + 1;
        this.tempsEspera = (int) (Math.random() * 15);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        if ( tempsEspera > 8) {
            try {
                System.out.println("Dona embarassada " + id + "  anant a al hospital... Temps d'arribada: " + tempsEspera + " segons");
                Thread.sleep(8000);
                System.out.println("Dona embarassada " + id + " ha donat llum abans d'entrar a la sala d'urgències");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                System.out.println("Dona embarassada " + id + "  anant a al hospital... Temps d'arribada: " + tempsEspera + " segons");
                Thread.sleep(tempsEspera * 1000);
                System.out.println("Dona embarassada " + id + " agafant torn per entrar a urgències");
                semaphore.acquire();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Dona embarassada " + id + " marxant amb el nadó...");
                semaphore.release();
            }
        }
    }
}
