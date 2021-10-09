public class DictionaryCommandline {
    DictionaryManagement DicMana = new DictionaryManagement();

    /**
     * print all words from dictionary.
     * 
     * @param dict
     */
    public void showAllWords(Dictionary dict) {
        dict.printDictionary();
    }

    public void saveDict(Dictionary dict) {
        dict.saveToFile();
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
        // DicMana.insertFromFile();
        Util.cls();

        System.out.println("--- DICTIONARY ---");
        System.out.println("  1. Tra tu");
        System.out.println("  2. Sua tu");
        System.out.println("  3. Them tu");
        System.out.println("  4. Xoa tu");
        System.out.println("  5. In tu dien");
        System.out.println("  6. Thoat");
        System.out.println();
        System.out.print(" Nhap lua chon: ");

        int n = Util.UserSelection();

        switch (n) {
            case 1:
                DicMana.dictionaryLookup();
                break;
            case 2:
                DicMana.wordFix();
                saveDict(DicMana.dict);
                break;
            case 3:
                System.out.println(" 1. Them tu ban phim");
                System.out.println(" 2. Them tu File");
                System.out.print(" Nhap lua chon: ");
                int x = Util.UserSelection();

                if (x == 1)
                    DicMana.insertFromCommandLine();
                else
                    DicMana.insertFromFile();

                break;
            case 4:
                DicMana.wordDelete();
                saveDict(DicMana.dict);
                break;
            case 5:
                showAllWords(DicMana.dict);
                break;
            case 6:
                System.exit(0);
        }

        Util.cls();
    }

}
