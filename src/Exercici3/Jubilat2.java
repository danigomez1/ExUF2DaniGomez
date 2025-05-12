package Exercici3;

import java.util.concurrent.Semaphore;

public class Jubilat2 extends Thread {
    private final int id;
    private final int tempsEspera;
    private final Semaphore semaphore;

    public Jubilat2(int id, Semaphore semaphore) {
        this.id = id + 1;
        this.tempsEspera = (int) (Math.random() * 15);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Jubilat " + id + "  anant a al hospital... Temps d'arribada: " + tempsEspera + " segons");
            Thread.sleep(tempsEspera * 1000);
            System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");
            semaphore.acquire();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Jubilat " + id + " sortint d'urgències");
            semaphore.release();

            //Tornar a agafar torn en bucle
            while (true) {
                try {
                    System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");
                    semaphore.acquire();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Jubilat " + id + " sortint d'urgències");
                    semaphore.release();
                }
            }
        }
    }
}
