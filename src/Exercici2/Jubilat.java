package Exercici2;

public class Jubilat extends Thread {
    private final int id;
    private final int tempsEspera;
    private final Monitor monitor;

    public Jubilat(int id, Monitor monitor) {
        this.id = id + 1;
        this.monitor = monitor;
        this.tempsEspera = (int) (Math.random() * 15);
    }

    @Override
    public void run() {
        try {
            System.out.println("Jubilat " + id + "  anant a al hospital... Temps d'arribada: " + tempsEspera + " segons");
            Thread.sleep(tempsEspera * 1000);
            System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");
            monitor.openReading();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Jubilat " + id + " sortint d'urgències");
            monitor.closeReading();

            //Tornar a agafar torn en bucle
            while (true) {
                try {
                    System.out.println("Jubilat " + id + " agafant torn per entrar a urgències");
                    monitor.openReading();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Jubilat " + id + " sortint d'urgències");
                    monitor.closeReading();
                }
            }
        }
    }
}
