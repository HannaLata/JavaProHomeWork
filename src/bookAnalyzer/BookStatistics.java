package bookAnalyzer;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BookStatistics {
    private Book book;
    private String content;

    public BookStatistics(Book book, String content) {
        this.book = book;
        this.content = content;
    }

    public void analyzeAndPrint() {
        WordAnalyzer wordAnalyzer = new WordAnalyzer(content);
        Map<String, Integer> frequencyData = wordAnalyzer.getWordFrequencyData();

        Map<String, Integer> sortedWords = sortMapByValueDescending(frequencyData);
        int uniqueWordCount = frequencyData.size();

        try {
            StatisticsWriter.writeStatistics(book, sortedWords, uniqueWordCount);
            System.out.println("Statistics saved in the file " + book.getName() + "_statistic.txt");
        } catch ( IOException e ) {
            System.out.println("Error writing statistics to the file: " + e.getMessage());
        }
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortMapByValueDescending(Map<K, V> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
