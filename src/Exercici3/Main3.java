package Exercici3;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main3 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantes dones embarassades hi han? ");
        int embarassades = sc.nextInt();

        System.out.println("Quantes dones jubilats hi han? ");
        int jubilats = sc.nextInt();

        sc.close();

        Embarassada2[] pacientsEmbarassades = new Embarassada2[embarassades];
        Jubilat2[] pacientsJubilats = new Jubilat2[jubilats];

        try {
            for (int i = 0; i < embarassades; i++) {
                pacientsEmbarassades[i] = new Embarassada2(i, semaphore);
                pacientsEmbarassades[i].start();
            }
            for (int i = 0; i < jubilats; i++) {
                pacientsJubilats[i] = new Jubilat2(i, semaphore);
                pacientsJubilats[i].start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
