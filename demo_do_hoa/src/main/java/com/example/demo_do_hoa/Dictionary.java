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
            File f = new File(HelloController.link + "dictword.txt");
            if (!f.isFile()) {
                f = new File(HelloController.link + "dictword.txt");
            }
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            String fromText;
            while ((fromText = br.readLine()) != null) {
                //String word;
                insertWord(fromText);
                //br.readLine();
            }
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }


    public void saveToFile() {

        try {
            File f = new File(HelloController.link + "dictword.txt");
            if (!f.isFile()) {
                f = new File(HelloController.link + "dictword.txt");
            }
            FileWriter fw = new FileWriter(f);

            Set<String> keySet = listdict.keySet();
            for (String key : keySet) {
                fw.write(key + '\n');
            }

            fw.close();

        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }

    public void insertWord(String word) {
        Word w = new Word(word);
        listdict.put(word, w);
    }

    public void deleteWord(String word) {
        try {
            File file = new File(HelloController.link + word + ".txt");
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listdict.remove(word);
    }

    public String lookWord(String word) {
        if (listdict.containsKey(word)) {
            return listdict.get(word).getWord_explain();
        }
        return "ko có từ này trong từ điển";
    }



    public String[] searcher(String word) {
        String[] list = new String[20];
        if (!listdict.containsKey(word)) {
            int n = word.length();
            int j = 0;
            Set<String> keySet = listdict.keySet();
            for (String key : keySet) {
                    int i = key.length();
                    if (i >= n) {
                        String s = key.substring(0, n);
                        if (s.equals(word)) {
                            list[j++] = key;
                            if (j == 20) {
                                break;
                            }
                        }
                    }
            }
            return list;
        }
        return list;
    }
}