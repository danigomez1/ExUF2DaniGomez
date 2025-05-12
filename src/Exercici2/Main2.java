package Exercici2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Monitor m = new Monitor();
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantes dones embarassades hi han? ");
        int embarassades = sc.nextInt();

        System.out.println("Quantes dones jubilats hi han? ");
        int jubilats = sc.nextInt();

        sc.close();

        Embarassada[] pacientsEmbarassades = new Embarassada[embarassades];
        Jubilat[] pacientsJubilats = new Jubilat[jubilats];

        try {
            for (int i = 0; i < embarassades; i++) {
                pacientsEmbarassades[i] = new Embarassada(i, m);
                pacientsEmbarassades[i].start();
            }
            for (int i = 0; i < jubilats; i++) {
                pacientsJubilats[i] = new Jubilat(i, m);
                pacientsJubilats[i].start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
