
// import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dict = new Dictionary();
    // DictionaryCommandline dicCmd = new DictionaryCommandline();

    // Scanner screen = new Scanner(System.in);

    // public void Menu() {
    // System.out.println("--- DICTIONARY ---");
    // System.out.println(" 1. Tra tu");
    // System.out.println(" 2. Sua tu");
    // System.out.println(" 3. Them tu");
    // System.out.println(" 4. Xoa tu");
    // System.out.println(" 5. In tu dien");
    // System.out.println();
    // System.out.print(" Nhap lua chon: ");

    // int n = screen.nextInt();

    // switch (n) {
    // case 1:
    // dictionaryLookup();
    // break;
    // case 2:
    // wordFix();
    // break;
    // case 3:
    // insertFromCommandLine();
    // break;
    // case 4:
    // wordDelete();
    // break;
    // case 5:
    // dicCmd.showAllWords(dict);
    // break;
    // }

    // cls();
    // }

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

    public void wordFix() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Nhap tu can sua:");
        System.out.println();

        System.out.print(" English: ");
        String word = sc.nextLine();

        System.out.println(" Tu dang co nghia: " + dict.lookWord(word));

        System.out.print(" Vietnamese: ");
        String wordE = sc.nextLine();

        dict.fixWord(word, wordE);

        System.out.println();
        System.out.println("Tu da duoc sua...");

        Util.pause(1000);

    }

    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Nhap tu can tra: ");
        String word = sc.nextLine();
        String s = dict.lookWord(word);

        if (s == null)
            System.out.println(" Khong co du lieu");
        else
            System.out.println("\n        Nghia cua tu: " + s);

        System.out.println("\n");
        System.out.println("  1. Menu");
        System.out.print(" Nhap luu chon: ");
        int exit = Util.UserSelection();
        if (exit == 1) {
            return;
        }
    }

    // public static void Util.pause(int ms) {
    // try {
    // Thread.sleep(ms);
    // } catch (InterruptedException e) {
    // System.err.format("IOException: %s%n", e);
    // }
    // }

    // public static void cls() {
    // // Clears Screen in java
    // try {
    // if (System.getProperty("os.name").contains("Windows"))
    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    // else
    // Runtime.getRuntime().exec("clear");
    // } catch (IOException | InterruptedException ex) {
    // }
    // }

}
