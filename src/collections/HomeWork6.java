package collections;

import java.util.*;

public class HomeWork6 {

    private static int countOccurance(List<String> wordList, String target) {
        int count = 0;
        for ( String word : wordList ) {
            if ( word.equals(target) ) {
                count++;
            }
        }
        return count;
    }

    private static List<Integer> toList(int [] nums) {
        List<Integer> result = new ArrayList<>();
        for ( int num : nums ) {
            result.add(num);
        }
        return result;
    }

    private static Set<Integer> findUnique(List<Integer> nums) {
        return new HashSet<>(nums);
    }

    private static void calcOccurance(List<String> wordList) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for ( String word : wordList ) {
            if ( wordCountMap.containsKey(word) ) {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        for ( Map.Entry<String, Integer> entry : wordCountMap.entrySet() ) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<Map<String, Object>> findOccurrence(List<String> wordList) {
        List<Map<String, Object>> result = new ArrayList<>();

        for ( String word : wordList ) {
            boolean found = false;
            for ( Map<String, Object> entry : result ) {
                if (entry.get("name").equals(word)) {
                    int occurrence = (int) entry.get("occurrence");
                    entry.put("occurrence", occurrence + 1);
                    found = true;
                    break;
                }
            }

            if ( !found ) {
                Map<String, Object> occurrenceMap = new HashMap<>();
                occurrenceMap.put("name", word);
                occurrenceMap.put("occurrence", 1);
                result.add(occurrenceMap);
            }
        }

        return result;
    }
}
