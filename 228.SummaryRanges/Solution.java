// Given a sorted integer array without duplicates, return the summary of its ranges.

// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> list = new LinkedList<>();
    if (nums == null || nums.length == 0) return list;

    int start = 0;

    for (int i = 1; i < nums.length; i++) {
    	if (nums[i] - nums[i - 1] == 1 && i != nums.length - 1) continue;
    	if (nums[i] - nums[i - 1] == 1 && i == nums.length - 1) {
    		list.add(nums[start] + "->" + nums[i]);
    	} else {
    		if (i - start > 1) list.add(nums[start] + "->" + nums[i - 1]);
    		else list.add(nums[start] + "");
    		start = i;
    	}
    }

    if (start == nums.length - 1) list.add(nums[start] + "");

    return list;
  }

  // easy to understand
  public List<String> summaryRanges(int[] nums) {
  	List<String> list = new LinkedList<>();
    if (nums == null || nums.length == 0) return list;

    for (int i = 0; i < nums.length; i++) {
    	int a = nums[i];

    	while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
    		i++;
    	}

    	if (a != nums[i]) list.add(a + "->" + nums[i]);
    	else list.add(a + "");
    }
    return list;
  }
}