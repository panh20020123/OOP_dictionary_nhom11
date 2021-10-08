
// import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    /*
     * dictionaryBasic // goi ham InsertFromCommandLine vs showAllWord
     * dictionaryAdvanced// goi ham InsetFromFile, showAllWords, dictionaryLookup
     * dictionarySearcher
     */

    DictionaryManagement DicMana = new DictionaryManagement();
    // Dictionary dictionary = new Dictionary();

    /**
     * print all words from dictionary.
     * 
     * @param dict
     */
    public void showAllWords(Dictionary dict) {
        dict.printDictionary();
    }

    /**
     * goi ham InsertFromCommandLine va ham showAllWords.
     * 
     */
    /*
     * public void dictionaryBasic() { Scanner sc = new Scanner(System.in);
     * 
     * System.out.println("--- DICTIONARY ---"); System.out.println(" 1. Tra tu");
     * System.out.println(" 2. Them tu"); System.out.println(" 3. In tu dien");
     * System.out.println(); System.out.print(" Nhap lua chon: ");
     * 
     * int n = sc.nextInt();
     * 
     * switch (n) { case 1: DicMana.dictionaryLookup(); break; case 2:
     * DicMana.insertFromCommandLine(); break; case 3: showAllWords(dictionary);
     * break; }
     * 
     * Util.cls(); }
     */

    /**
     * goi ham InsertFromCommandLine , ham showAllWords , ham dictionaryLookup.
     * 
     */
    public void dictionaryAdvanced() {
        Scanner sc = new Scanner(System.in);

        // DicMana.insertFromFile();
        System.out.println("--- DICTIONARY ---");
        System.out.println("  1. Tra tu");
        System.out.println("  2. Sua tu");
        System.out.println("  3. Them tu");
        System.out.println("  4. Xoa tu");
        System.out.println("  5. In tu dien");
        System.out.println("  6. Thoat");
        System.out.println();
        System.out.print(" Nhap lua chon: ");

        int n = sc.nextInt();

        switch (n) {
            case 1:
                DicMana.dictionaryLookup();
                break;
            case 2:
                DicMana.wordFix();
                break;
            case 3:
                DicMana.insertFromCommandLine();
                break;
            case 4:
                DicMana.wordDelete();
                // break;
            case 5:
                showAllWords(DicMana.dict);
                break;
            case 6:
                System.exit(0);
        }

        Util.cls();
    }

    // public static void cls() {
    // // Clears sc in java
    // try {
    // if (System.getProperty("os.name").contains("Windows"))
    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    // else
    // Runtime.getRuntime().exec("clear");
    // } catch (IOException | InterruptedException ex) {
    // }
    // }
}
