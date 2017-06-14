// Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
// O(n) run time, O(n) space
  public boolean containsDuplicate(int[] nums) {
  	if(nums == null || nums.length <= 1) return false;
    Set<Integer> set = new HashSet<>();

    for(int num : nums) {
    	if(!set.add(num)) return true;
    }
    return false;
  }

// O(n^2) run time, O(1) space  (Time limit exceeds)
  // public boolean containsDuplicate(int[] nums) {
  //   for(int i = 0; i < nums.length - 1; i++) {
  //     for(int j = i + 1; j < nums.length; j++) {
  //       if(nums[i] == nums[j]) return true;
  //     }
  //   }
  //   return false;
  // }

  // O(nlgn) run time, O(1) space (if not consider memory used in sorting) (Time limit exceeds)
  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 1; i++) {
      if(nums[i] == nums[i+1]) return true;
    }
    return false;
  }


  public static void main(String[] args) {
  	int[] nums = {1,3,5,2,77,2};
  	Solution s = new Solution();
  	System.out.println(s.containsDuplicate(nums));
  }
}