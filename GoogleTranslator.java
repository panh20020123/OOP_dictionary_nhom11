import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.TreeMap;

public class GoogleTranslator {
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

    public static String[] lang = {
        "Auto Detect",
        "Afrikaans",
        "Albanian",
        "Arabic",
        "Azerbaijani",
        "Basque",
        "Bengali",
        "Belarusian",
        "Bulgarian",
        "Catalan",
        "Chinese Simplified",
        "Chinese Traditional",
        "Croatian",
        "Czech",
        "Danish",
        "Dutch",
        "English",
        "Esperanto",
        "Estonian",
        "Filipino",
        "Finnish",
        "French",
        "Galician",
        "Georgian",
        "German",
        "Greek",
        "Gujarati",
        "Haitian Creole",
        "Hebrew",
        "Hindi",
        "Hungarian",
        "Icelandic",
        "Indonesian",
        "Irish",
        "Italian",
        "Japanese",
        "Kannada",
        "Korean",
        "Latin",
        "Latvian",
        "Lithuanian",
        "Macedonian",
        "Malay",
        "Maltese",
        "Norwegian",
        "Persian",
        "Polish",
        "Portuguese",
        "Romanian",
        "Russian",
        "Serbian",
        "Slovak ",
        "Slovenian",
        "Spanish",
        "Swahili",
        "Swedish",
        "Tamil",
        "Telugu ",
        "Thai",
        "Turkish",
        "Ukrainian",
        "Urdu",
        "Vietnamese",
        "Welsh",
        "Yiddish"
    };

    public static String[] shortLang = {
        "",
        "af",
        "sq",
        "ar",
        "az",
        "eu",
        "bn",
        "be",
        "bg",
        "ca",
        "zh-CN",
        "zh-TW",
        "hr",
        "cs",
        "da",
        "nl",
        "en",
        "eo",
        "et",
        "tl",
        "fi",
        "fr",
        "gl",
        "ka",
        "de",
        "el",
        "gu",
        "ht",
        "iw",
        "hi",
        "hu",
        "is",
        "id",
        "ga",
        "it",
        "ja",
        "kn",
        "ko",
        "la",
        "lv",
        "lt",
        "mk",
        "ms",
        "mt",
        "no",
        "fa",
        "pl",
        "pt",
        "ro",
        "ru",
        "sr",
        "sk",
        "sl",
        "es",
        "sw",
        "sv",
        "ta",
        "te",
        "th",
        "tr",
        "uk",
        "ur",
        "vi",
        "cy",
        "yi",
    };

    public static TreeMap<String, String> languages = new TreeMap<String, String>();
    
    public static void setLanguages() {
        for (int i = 0; i < lang.length; i++) {
            languages.put(lang[i], shortLang[i]);
        }
    }
}