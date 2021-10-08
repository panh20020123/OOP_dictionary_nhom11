import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
    public TreeMap<String, Word> listdict;

    public Dictionary() {
        listdict = new TreeMap<String, Word>();
    }

    public void printDictionary() {
        Util.cls();
        System.out.println("--- DICTIONARY ---");
        System.out.println("No   | English      | Vietnamese ");

        Set<String> keySet = listdict.keySet();
        int i = 0;

        for (String key : keySet) {
            i++;
            System.out.print(i + " ");
            System.out.println(listdict.get(key).toString());
        }
        System.out.println("\n");
        System.out.println("  1. Menu");
        System.out.print(" Nhap luu chon: ");
        int exit = Util.UserSelection();
        if (exit == 1) {
            return;
        }
    }

    public void insertWord(String word, String wordE) {
        Word w = new Word(word, wordE);
        listdict.put(word, w);
    }

    public void deleteWord(String word) {
        listdict.remove(word);
    }

    public void fixWord(String word, String wordE) {
        listdict.remove(word);
        insertWord(word, wordE);
    }

    // public String lookWord(String word) {
    // if (!listdict.containsKey(word))
    // return null;
    // return listdict.get(word).toString();
    // }

    public String lookWord(String word) {
        if (!listdict.containsKey(word))
            return null;
        return listdict.get(word).getWord_explain();
    }

}
