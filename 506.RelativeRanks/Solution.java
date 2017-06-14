// Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

// Example 1:
// Input: [5, 4, 3, 2, 1]
// Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
// Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
// For the left two athletes, you just need to output their relative ranks according to their scores.
// Note:
// N is a positive integer and won't exceed 10,000.
// All the scores of athletes are guaranteed to be unique.

public class Solution {
  public String[] findRelativeRanks(int[] nums) {
    Map<Integer, Integer> location = new HashMap<>();
    Map<Integer, String> rank = new HashMap<>();
    String[] res = new String[nums.length];

    for (int i = 0; i < nums.length; i++) {
    	location.put(i, nums[i]);
    }

    Arrays.sort(nums);

    for (int i = nums.length - 1; i >= 0; i--) {
    	if (i == nums.length - 1) rank.put(nums[i], "Gold Medal");
    	else if (i == nums.length - 2) rank.put(nums[i], "Silver Medal");
    	else if (i == nums.length - 3) rank.put(nums[i], "Bronze Medal");
    	else {
    		rank.put(nums[i], nums.length - i + "");
    	}
    }

    for (int i = 0; i < nums.length; i++) {
    	res[i] = rank.get(location.get(i));
    }
    return res;
  }
}