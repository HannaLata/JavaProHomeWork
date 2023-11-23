import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the book title: ");
        String bookName = scanner.nextLine();

        File bookFile = new File("src/" + bookName + ".txt");

        if (!bookFile.exists()) {
            System.out.println("Book not found in the src/ directory.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(bookFile))) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            String content = contentBuilder.toString();
            analyzeAndPrintStatistics(bookName, content);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void analyzeAndPrintStatistics(String bookName, String content) {
        String[] words = content.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            if (word.matches("[a-zA-Z]+") && word.length() > 2) {
                word = word.toLowerCase();
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        Map<String, Integer> sortedWords = sortMapByValueDescending(wordCountMap);
        int uniqueWordCount = wordCountMap.size();

        try (FileWriter writer = new FileWriter(bookName + "_statistic.txt")) {
            writer.write("Word -> Frequency\n-------------------------\n");

            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
                writer.write(entry.getKey() + " -> " + entry.getValue() + "\n");
                if (++count == 10) break;
            }

            writer.write("-------------------------\nTotal words: " + uniqueWordCount);

            System.out.println("Statistics saved in the file " + bookName + "_statistic.txt");
        } catch (IOException e) {
            System.out.println("Error writing statistics to the file: " + e.getMessage());
        }
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValueDescending(Map<K, V> map) {
        Map<K, V> sortedMap = new HashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }
}
