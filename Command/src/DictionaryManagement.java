import java.io.*;
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
        try {
            System.out.print("Nhap file muon them: ");
            Scanner sc = new Scanner(System.in);

            String s = sc.nextLine();
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("./src/" + s);
            FileReader fr = new FileReader(f);
            //Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);

            String fromText;
            while ((fromText = br.readLine()) != null){
                String word;
                String wordE;
                for (int i = 0; i < fromText.length(); i++) {
                    if (fromText.charAt(i) == ' ') {
                        word = fromText.substring(0, i);
                        wordE = fromText.substring(i);

                        dict.insertWord(word, wordE);
                        break;
                    }
                }
                br.readLine();
            }
            //Bước 3: Đóng luồng
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: "+ex);
        }
    }

    public void wordFix() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Nhap tu can sua:");
        System.out.println();

        System.out.print(" English: ");
        String word = sc.nextLine();

        if(dict.lookWord(word) == null) System.out.println("Khong co du lieu ");
        else {
            System.out.println(" Tu dang co nghia: " + dict.lookWord(word));

            System.out.print(" Vietnamese: ");
            String wordE = sc.nextLine();

            dict.fixWord(word, wordE);

            System.out.println();
            System.out.println("Tu da duoc sua...");
        }

        Util.pause(1000);

    }

    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap tu can tra: ");
        String word = sc.nextLine();
        String s = dict.lookWord(word);

        if (s == null) {
            searcherWord(word);
        }
        else {
            System.out.println("\n      Nghia cua tu: " + s);
            System.out.println("\n");
        }
        Util.pause(1000);

        System.out.println("  1. Ve Menu");
        System.out.print(" Nhap luu chon: ");

        int exit = Util.UserSelection();
        if (exit == 1) {
                return;
        }
    }

    public void searcherWord(String word){
        String s = dict.searcher(word);
        if(s == "") System.out.println("....");
        else System.out.println(s);
        System.out.println();
    }

}
