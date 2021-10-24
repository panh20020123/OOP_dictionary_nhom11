package com.example.demo_do_hoa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GoogleTranslator {
    // public static void main(String[] args) throws IOException {
    //     Scanner scanner = new Scanner(System.in);
    //     String text = scanner.nextLine();
    //     // String text = "easy";
    //     // System.out.println("Translated text: " + translate("en", "vi", text));
    //     System.out.println(translate("", "vi", text));
    //     scanner.close();
    // }

    public static String translate(String langFrom, String langTo, String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbyPaJa5PXO8Sla7H6SAFrZyzMMtbzdMW4_OHB42yBvgz0VA99OcPbZzWdr2hr-_Kp1T/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}