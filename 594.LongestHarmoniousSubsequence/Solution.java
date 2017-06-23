// We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

// Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

// Example 1:
// Input: [1,3,2,2,5,2,3,7]
// Output: 5
// Explanation: The longest harmonious subsequence is [3,2,2,2,3].
// Note: The length of the input array will not exceed 20,000.
import java.util.*;
public class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                count = map.get(key) + map.get(key + 1);
                max = Math.max(max, count);
            }
        }
        return max;
        // List<Integer> list = new ArrayList<>();
        // for (int num : nums) {
        //     if (list.size() == 0) list.add(num);
        //     if (num != list.get(list.size() - 1)) list.add(num);
        // }

        // if (list.size() == 1) return 0;

        // for (int i = 1; i < list.size(); i++) {
        //     int prev = list.get(i - 1);
        //     int curr = list.get(i);
        //     if (curr - prev == 1) {
        //         count = map.get(prev) + map.get(curr);
        //         max = Math.max(max, count);
        //     }            
        // }
        // return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        Solution s = new Solution();
        System.out.println(s.findLHS(nums));
    }
}