package com.example.demo_do_hoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Word {
    private String Word_target;

    private String Word_spelling;

    public String getWord_spelling() {
        return Word_spelling;
    }

    public void setWord_spelling(String Word_spelling) {
        this.Word_spelling = Word_spelling;
    }

    public String getWord_target() {
        return Word_target;
    }

    public void setWord_target(String Word_target) {
        this.Word_target = Word_target;
    }

    public String getWord_explain() {

        String explain = "";
        try {
            String file =  Word_target + ".txt";
            File f = new File(file);

            if (!f.isFile()) {
                f = new File(file);
            }
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            String fromText;

            while ((fromText = br.readLine()) != null) {
                explain +=  "\n" +  fromText;
            }

            fr.close();
            br.close();

        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
        return toString() + explain;

    }


    public Word(String Word_target, String Word_spelling) {
        this.Word_spelling = Word_spelling;
        this.Word_target = Word_target;
    }

    /**
     * print
     *
     * @return string
     */
    public String toString() {
        return Word_target + " " + Word_spelling + " " + "\n";
    }
}

