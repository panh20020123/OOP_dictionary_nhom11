package com.example.demo_do_hoa;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
    public TreeMap<String, Word> listdict;
    public Dictionary() {
        listdict = new TreeMap<String, Word>();
        try {
            File f = new File("dictionaries.txt");
            if (!f.isFile()) {
                f = new File("dictionaries.txt");
            }
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
                        insertWord(word, wordE);
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

    public void saveToFile() {

        try {
            File f = new File("dictionaries.txt");
            if (!f.isFile()) {
                f = new File("dictionaries.txt");
            }
            FileWriter fw = new FileWriter(f);

            Set<String> keySet = listdict.keySet();
            for (String key : keySet) {
                fw.write(key + "\t" + listdict.get(key).getWord_spelling() + '\n' + '\n');
            }

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
        try {
            File file = new File(word + ".txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
        listdict.remove(word);
    }

    public void fixWord(String word, String spe, String wordE) {
        if (!spe.equals("0")) {
            listdict.get(word).setWord_spelling(spe);
        }
        if (!wordE.equals("0")) {
            try {
                FileWriter fw = new FileWriter(new File(word + ".txt"));
                fw.write(wordE);
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi ghi file: " + ex);
            }
        }
    }

    public String lookWord(String word) {

        if (listdict.containsKey(word)) {
            return listdict.get(word).getWord_explain();
        }
        return "ko có dữ liệu";
    }
}
