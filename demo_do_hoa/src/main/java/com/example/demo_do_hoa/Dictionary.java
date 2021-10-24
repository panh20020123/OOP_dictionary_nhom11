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

    //String link = "C:\\Users\\admin\\Downloads\\textwords\\textwords"
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

    public void fixWord(String word, String spe, String wordE) {
//        if (!spe.equals("0")) {
//            listdict.get(word).setWord_spelling(spe);
//        }
//        if (!wordE.equals("0")) {
//            try {
//                FileWriter fw = new FileWriter(new File(word + ".txt"));
//                fw.write(wordE);
//                fw.close();
//            } catch (IOException ex) {
//                System.out.println("Loi ghi file: " + ex);
//            }
//        }
    }


    public String lookWord(String word) {
        if (listdict.containsKey(word)) {
            return listdict.get(word).getWord_explain();
        }
        return "ko có từ này trong từ điển";
    }


    //ArrayList<String> containsInput = new ArrayList<String>();
    public String[] searcher(String word) {
        // String kq = "";
        String[] list = new String[20];
        if (!listdict.containsKey(word)) {
            int n = word.length();
            int j = 0;
            Set<String> keySet = listdict.keySet();
           // int count = 0;
            for (String key : keySet) {
                //if (count < 50) {
                    int i = key.length();
                    if (i >= n) {
                        String s = key.substring(0, n);
                        if (s.equals(word)) {
                            // kq = kq + " - " + key;
                            list[j++] = key;
                            if (j == 20) {
                                break;
                            }
                            //containsInput.add(key);
                            //count++;
                        }
                    }
               // } else
                  //  break;
            }
            return list;
            // return kq;
        }
        return list;
    }



}