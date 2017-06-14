// Given an array of integers and an integer k, 
// find out whether there are two distinct indices i and j in the array such that 
// nums[i] = nums[j] and the difference between i and j is at most k.
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length == 0) return false;
    if (k == 0) return false;

    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
    	if (i > k) set.remove(nums[i - k - 1]);
    	if (!set.add(nums[i])) return true;
    }
    return false;
  }

  public static void main(String[] args) {
  	int[] nums = {1,2,1};
  	int k = 1;
  	Solution s = new Solution();
  	System.out.println(s.containsNearbyDuplicate(nums,k));

  	
  	// List<Integer> l = new LinkedList<>();
  	// l.add(1);
  	// l.add(2);
  	// l.remove(new Integer(1));
  	// l.remove(1);
  	// System.out.println(l);

  }
}
