// Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

// Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

// Could you do this in O(n) runtime?

// Example:

// Input: [3, 10, 5, 25, 2, 8]

// Output: 28

// Explanation: The maximum result is 5 ^ 25 = 28.


public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask); // use mask to see only one bit of each num at a time and store them in a set
            }

            int temp = max | (1 << i); // temp is the max result we could get
            // Iterator<Integer> it = set.iterator();
            // while (it.hasNext()) {
            //     int num = it.next();
            //     if (set.contains(num ^ temp)) {
            //         max = temp;
            //         break;
            //     }
            // }
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) { // tmp ^ pre1 = pre2 means pre1 ^ pre2 = tmp
                                                   // It means we can get temp as to speak the specific bit
                                                   // then give temp to max
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}