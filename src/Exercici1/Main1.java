package Exercici1;

public class Main1 {
    public static void main(String[] args) {
        TiradaDau t1 = new TiradaDau(1);
        TiradaDau t2 = new TiradaDau(2);
        TiradaDau t3 = new TiradaDau(3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float mitjana = (float) (t1.valorDau + t2.valorDau + t3.valorDau) / 3;
        System.out.println("Mitjana de les tirades: " + mitjana);
        System.out.println("Número de guàrdies: " + Math.round(mitjana));
    }
}
