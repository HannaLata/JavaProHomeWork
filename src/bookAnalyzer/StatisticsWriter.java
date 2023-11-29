package bookAnalyzer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class StatisticsWriter {
    public static void writeStatistics(Book book, Map<String, Integer> wordCountMap, int uniqueWordCount) throws IOException {
        try ( FileWriter writer = new FileWriter(book.getName() + "_statistic.txt") ) {
            writer.write("Word -> Frequency\n-------------------------\n");

            int count = 0;
            for ( Map.Entry<String, Integer> entry : wordCountMap.entrySet() ) {
                writer.write(entry.getKey() + " -> " + entry.getValue() + "\n");
                if ( ++count == 10 ) break;
            }

            writer.write("-------------------------\nTotal words: " + uniqueWordCount);
        }
    }
}
