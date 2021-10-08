import java.io.File;
import java.io.FileNotFoundException;
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
        // File text = new
        // File("F:/2Study/2Nam2/CS/OOP/Dictionary/OOP_dictionary_nhom11/Command/src/dictionaries.txt");
        // String path = new File("Command/src/dictionaries.txt").getAbsolutePath();
        // File text = new File(path);
        File text = new File("./Command/src/dictionaries.txt");

        try {
            Scanner sc = new Scanner(text);
            while (sc.hasNextLine()) {
                String word;
                String wordE;
                // String word = sc.nextLine();
                // String wordE = sc.nextLine();
                String fromText = sc.nextLine();
                for (int i = 0; i < fromText.length(); i++) {
                    if (fromText.charAt(i) == ' ') {
                        word = fromText.substring(0, i);
                        wordE = fromText.substring(i);
                        dict.insertWord(word, wordE);
                        break;
                    }
                }
                // String s = sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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

}
