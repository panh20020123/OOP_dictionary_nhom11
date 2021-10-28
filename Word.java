import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class Word {
    private String Word_target;
    public String getWord_target() {
        return Word_target;
    }

    public void setWord_target(String Word_target) {
        this.Word_target = Word_target;
    }

    public String getWord_explain() {

        String explain = "";
        try {
            String file =  HelloController.link + getWord_target() + ".txt";
            File f = new File(file);

            if (!f.isFile()) {
                f = new File(file);
            }
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            String fromText;

            while ((fromText = br.readLine()) != null) {
                explain +=  fromText + "\n";
            }

            fr.close();
            br.close();

        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
        return explain;

    }


    public Word(String Word_target) {
        this.Word_target = Word_target;
    }

    public String getAudioLink() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.dictionaryapi.dev/api/v2/entries/en/" + getWord_target())).build();
            return "https:" +  client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
                    .thenApply(Word::parse).join();
        } catch (Exception e) {
            return "https://translate.google.com/translate_tts?ie=UTF-8&client=tw-ob&tl=en&q=" + (getWord_target().contains(" ") ? String.join("+", (getWord_target().split(" "))) : getWord_target());
        }
    }
    public static String parse(String responseBody) {
        JSONArray word_response = new JSONArray(responseBody);
        JSONObject word = word_response.getJSONObject(0);
        JSONArray phonetics = word.getJSONArray("phonetics");
        String audioLink = null;
        for (int i = 0; i < phonetics.length(); i++) {
            JSONObject phonetic = phonetics.getJSONObject(0);

             audioLink = (String) phonetic.get("audio");

        }
        return audioLink;
    }
}

