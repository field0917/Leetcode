// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.

public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
  	if (nums1.length == 0 || nums2.length == 0) return new int[0];

    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int i = 0; i < nums1.length; i++) {
    	set1.add(nums1[i]);
    }

    for (int i = 0; i < nums2.length; i++) {
    	if (set1.contains(nums2[i])) set2.add(nums2[i]);
    }

    Iterator iter = set2.iterator();
    int[] res = new int[set2.size()];

    for (int i = 0; i < res.length; i++) {
    	res[i] = (int) iter.next();
    }
    return res;
  }
}