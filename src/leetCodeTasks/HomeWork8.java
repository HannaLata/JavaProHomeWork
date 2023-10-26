package leetCodeTasks;

import java.util.*;

public class HomeWork8 {

    private static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for ( int num : nums ) {
            if ( set.contains(num) ) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < nums.length; i++ ) {
            int complement = target - nums[i];
            if ( map.containsKey(complement) ) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
