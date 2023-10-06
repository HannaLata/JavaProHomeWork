package leetCodeTasks;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isAnagramFirstSolution("anagram", "nagaram"));
        System.out.println(isAnagramFirstSolution("rat", "car"));
        System.out.println(isAnagramSecondSolution("anagram", "nagaram"));
        System.out.println(isAnagramSecondSolution("rat", "car"));
    }
    public static boolean isAnagramFirstSolution(String firstStr, String secondStr) {
        if ( firstStr.length() != secondStr.length() ) {
            return false;
        }
        char[] firstStrAsCharArray = firstStr.toCharArray();
        char[] secondStrAsCharArray = secondStr.toCharArray();
        Arrays.sort(firstStrAsCharArray);
        Arrays.sort(secondStrAsCharArray);
        return Arrays.equals(firstStrAsCharArray, secondStrAsCharArray);
    }

    public static boolean isAnagramSecondSolution(String firstStr, String secondStr) {
        if ( firstStr.length() != secondStr.length() ) {
            return false;
        }
        String firstStrSorted = Stream.of(firstStr.split(""))
                .sorted()
                .collect(Collectors.joining());
        String secondStrSorted = Stream.of(secondStr.split(""))
                .sorted()
                .collect(Collectors.joining());
        return firstStrSorted.equals(secondStrSorted);
    }
}
