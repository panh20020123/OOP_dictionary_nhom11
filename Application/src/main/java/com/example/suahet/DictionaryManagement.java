package com.example.suahet;
import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dict = new Dictionary();

    public void wordDelete() {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Nhap tu can xoa: ");
        String word = sc.nextLine();

        dict.deleteWord(word);

        System.out.println();
        System.out.println("Tu da duoc xoa...");
        Util.pause(1000);

    }

    public void insertFromCommandLine() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Nhap tu can them:");
        System.out.println();

        System.out.print(" English: ");
        String word = sc.nextLine();

        System.out.print(" Vietnamese: ");
        String wordE = sc.nextLine();

        dict.insertWord(word, wordE);

        System.out.println();
        System.out.println("Tu da duoc them...");

        Util.pause(1000);
    }

    public void insertFromFile() {
        System.out.print("Nhap file muon them: ");
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        try {
            File f = new File("Command/src/" + s + ".txt");
            // System.out.println(f.getAbsolutePath());
            // Util.pause(5000);

            if (!f.isFile()) {
                // System.out.println("nope");
                f = new File(s + ".txt");
            }
            // System.out.println(f.getAbsolutePath());
            // Util.pause(5000);
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            String fromText;
            while ((fromText = br.readLine()) != null) {
                String word;
                String wordE;
                for (int i = 0; i < fromText.length(); i++) {
                    if (fromText.charAt(i) == '\t') {
                        word = fromText.substring(0, i);
                        wordE = fromText.substring(i + 1);

                        dict.insertWord(word, wordE);
                        break;
                    }
                }
                br.readLine();
            }

            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }

    public void wordFix() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Nhap tu can sua:");
        System.out.println();

        System.out.print(" English: ");
        String word = sc.nextLine();

        if (dict.lookWord(word) == null)
            System.out.println("Khong co du lieu ");
        else {
            System.out.println(" Tu dang co nghia: " + dict.lookWord(word));

            System.out.print(" Vietnamese: ");
            String wordE = sc.nextLine();

            dict.fixWord(word, wordE);

            System.out.println();
            System.out.println("Tu da duoc sua...");
        }

        Util.pause(1000);

    }

    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap tu can tra: ");

        String word = dictionarySearcher(sc.nextLine());
        // System.out.println(word);
        if (word.equals("")) {
            System.out.print(
                    "\nKhong tim thay tu trong tu dien.\nBan co muon them tu?\n 1. Them tu\n 2. Ve Menu\n Nhap lua chon: ");
            int action = Util.UserSelection();
            if (action == 1) {
                insertFromCommandLine();
            } else
                return;
        } else if (word == "2.exit") {
            return;
        } else {
            System.out.println("\n      Nghia cua tu " + word + ": " + dict.lookWord(word));
            System.out.println("\n");
        }
        Util.pause(1000);

        System.out.println("  1. Ve Menu");
        System.out.print(" Nhap luu chon: ");

        int exit = Util.UserSelection();
        if (exit == 1) {
            return;
        }
    }

    public String dictionarySearcher(String word) {
        return dict.searcher(word);
    }

}
