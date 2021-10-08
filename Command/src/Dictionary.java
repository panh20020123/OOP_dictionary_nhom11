import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
    public TreeMap<String, Word> listdict = new TreeMap<String, Word>();

    public void printDictionary() {
        System.out.println("No   | English      | Vietnamese ");

        Set<String> keySet = listdict.keySet();
        int i = 0;
        for (String key : keySet) {
            i++;
            System.out.print(i + "    ");
            System.out.println(listdict.get(key).toString());
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

    public String lookWord(String word) {
        if(!listdict.containsKey(word)) return null;
        return listdict.get(word).toString();
    }

}
