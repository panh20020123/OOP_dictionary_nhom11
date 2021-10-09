import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, Word> listdict;

    public Dictionary() {
        listdict = new TreeMap<String, Word>();
        try {
            // Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("./src/dictionaries.txt");
            FileReader fr = new FileReader(f);
            // Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);

            String fromText;
            while ((fromText = br.readLine()) != null) {
                String word;
                String wordE;
                for (int i = 0; i < fromText.length(); i++) {
                    if (fromText.charAt(i) == ' ') {
                        word = fromText.substring(0, i);
                        wordE = fromText.substring(i);
                        insertWord(word, wordE);
                        break;
                    }
                }
                br.readLine();
            }
            // Bước 3: Đóng luồng
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
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
        System.out.println("  1. Ve Menu");
        System.out.print(" Nhap luu chon: ");
        int exit = Util.UserSelection();
        if (exit == 1) {
            return;
        }
    }

    public void saveToFile() {

        try {
            // Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("./Command/src/dictionaries.txt");
            FileWriter fw = new FileWriter(f);
            // Bước 2: Ghi dữ liệu
            Set<String> keySet = listdict.keySet();
            for (String key : keySet) {
                fw.write(key + " " + listdict.get(key).getWord_explain() + '\n' + '\n');
            }
            // Bước 3: Đóng luồng
            fw.close();

        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
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
        if (!listdict.containsKey(word))
            return null;
        return listdict.get(word).getWord_explain();
    }

    public String searcher(String word) {
        // String kq = "";
        if (!listdict.containsKey(word)) {
            int n = word.length();
            ArrayList<String> containsInput = new ArrayList<String>();
            Set<String> keySet = listdict.keySet();
            int count = 0;
            for (String key : keySet) {
                if (count < 5) {
                    int i = key.length();
                    if (i >= n) {
                        String s = key.substring(0, n);
                        if (s.equals(word)) {
                            // kq = kq + " - " + key;
                            containsInput.add(key);
                            count++;
                        }
                    }
                } else
                    break;
            }
            if (containsInput.size() > 0) {
                System.out.println("Co phai ban dinh tim: ");
                for (int i = 0; i < containsInput.size(); i++) {
                    System.out.println((i + 1) + ". " + containsInput.get(i));
                }
                System.out.print(" \n 1. Chon tu de tra \n 2. Ve Menu \n Nhap lua chon: ");
                int action = Util.UserSelection();
                if (action == 1) {
                    System.out.print("Chon so thu tu cua tu de tra: ");
                    // kq += lookWord(containsInput.get(Util.UserSelection() - 1));
                    // kq += containsInput.get(Util.UserSelection() - 1);
                    word = containsInput.get(Util.UserSelection() - 1);
                }
            } else
                return word;
            // return kq;
        }
        return word;
    }

}
