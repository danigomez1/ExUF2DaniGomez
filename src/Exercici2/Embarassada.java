package Exercici2;

public class Embarassada extends Thread {
    private final int id;
    private final int tempsEspera;
    private final Monitor monitor;

    public Embarassada(int id, Monitor monitor) {
        this.id = id + 1;
        this.monitor = monitor;
        this.tempsEspera = (int) (Math.random() * 15);
    }

    @Override
    public void run() {
        try {
            System.out.println("Dona embarassada " + id + "  anant a al hospital... Temps d'arribada: " + tempsEspera + " segons");
            Thread.sleep(tempsEspera * 1000);
            System.out.println("Dona embarassada " + id + " agafant torn per entrar a urgències");
            monitor.openReading();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Dona embarassada " + id + " marxant amb el nadó...");
            monitor.closeReading();
        }
    }
}
