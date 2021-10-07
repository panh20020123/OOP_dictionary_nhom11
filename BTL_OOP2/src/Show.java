import edu.princeton.cs.algs4.StdIn;
import java.util.Scanner;

public class Show {
    Scanner sc = new Scanner(System.in);

    public void Menu() {
        System.out.println("- DICTIONARY -");
        System.out.println("Nhap lua chon:");
        System.out.println("1. Tra tu");
        System.out.println("2. Sua tu");
        System.out.println("3. Them tu");
        System.out.println("4. Xoa tu");

        int n = sc.nextInt();

        switch (n) {
            case 1:
                WordLook();
                break;
            case 2:
                System.out.print("Nhap tu muon sua: ");
                String wordFix = StdIn.readString();
                //Insert..
                break;
            case 3:
                System.out.print("Nhap tu muon them: ");
                String wordAdd = StdIn.readString();
                //insert
                break;
            case 4:
                System.out.print("Nhap tu muon xoa: ");
                String wordDelete = StdIn.readString();
                //delete
                break;
        }

    }

    public void WordLook() {
        System.out.println("Nhap tu muon tra");
        String wordLook = StdIn.readString();

    }


}
