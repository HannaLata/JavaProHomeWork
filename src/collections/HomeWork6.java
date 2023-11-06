package collections;

import java.util.*;

public class HomeWork6 {

    private static int countOccurance(List<String> words, String target) {
        int count = 0;
        for ( String word : words ) {
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

    private static void calcOccurance(List<String> words) {
        Map<String, Integer> result = new HashMap<>();

        for ( String word : words ) {
            if ( result.containsKey(word) ) {
                int count = result.get(word);
                result.put(word, count + 1);
            } else {
                result.put(word, 1);
            }
        }

        for ( Map.Entry<String, Integer> entry : result.entrySet() ) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<Map<String, Object>> findOccurrence(List<String> words) {
        List<Map<String, Object>> result = new ArrayList<>();

        for ( String word : words ) {
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
                Map<String, Object> output = new HashMap<>();
                output.put("name", word);
                output.put("occurrence", 1);
                result.add(output);
            }
        }

        return result;
    }
}
