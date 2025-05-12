package Exercici1;

public class TiradaDau extends Thread {
    private final int id;
    final int valorDau;

    public TiradaDau(int id) {
        this.id = id;
        this.valorDau = (int) Math.round(Math.random() * 6);
    }

    @Override
    public void run() {
        System.out.println("Tirada dau Resident " + id + ": " + valorDau);
    }
}
