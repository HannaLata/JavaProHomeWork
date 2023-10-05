import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static boolean isAnagramFirstSolution(String firstStr, String secondStr) {
        if ( firstStr.length() != secondStr.length() ) {
            return false;
        }
        char[] firstStrAsArray = firstStr.toCharArray();
        char[] secondStrAsArray = secondStr.toCharArray();
        Arrays.sort(firstStrAsArray);
        Arrays.sort(secondStrAsArray);
        return Arrays.equals(firstStrAsArray, secondStrAsArray);
    }

    public static boolean isAnagramSecondSolution(String firstStr, String secondStr) {
        if ( firstStr.length() != secondStr.length() ) {
            return false;
        }
        firstStr = Stream.of(firstStr.split(""))
                .sorted()
                .collect(Collectors.joining());
        secondStr = Stream.of(secondStr.split(""))
                .sorted()
                .collect(Collectors.joining());
        return firstStr.equals(secondStr);
    }
}
