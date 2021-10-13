package com.example.suahet;

import java.io.IOException;
import java.util.Scanner;

/**
 * class dung cho cac function chung, dung duoc trong nhieu file khac
 */
public class Util {
    public static void cls() {
        // Clears sc in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static int UserSelection() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // if (sc.hasNext()) {
        // sc.close();
        // }
        return n;
    }
}

