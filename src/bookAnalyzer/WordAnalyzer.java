package bookAnalyzer;

import java.util.HashMap;
import java.util.Map;

public class WordAnalyzer {
    private String content;

    public WordAnalyzer(String content) {
        this.content = content;
    }

    public Map<String, Integer> getWordFrequencyData() {
        String[] words = content.split("\\s+");
        Map<String, Integer> frequencyData = new HashMap<>();

        for ( String word : words ) {
            if ( word.matches("[a-zA-Z]+") && word.length() > 2 ) {
                word = word.toLowerCase();
                frequencyData.put(word, frequencyData.getOrDefault(word, 0) + 1);
            }
        }

        return frequencyData;
    }
}
