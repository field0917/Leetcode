// Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

// Example 1:
// Input: [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number; 
// The second 1's next greater number needs to search circularly, which is also 2.
// Note: The length of given array won't exceed 10000.


public class Solution {
  public int[] nextGreaterElements(int[] nums) {
    if (nums == null || nums.length == 0) return new int[0];

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
    	res[i] = Integer.MIN_VALUE;
    }

    boolean found = false;

    for (int i = 0; i < nums.length; i++) {
    	found = false;
    	for (int j = i + 1; j < nums.length; j++) {
    		if (nums[j] > nums[i]) {
    			res[i] = nums[j];
    			found = true;
    			break;
    		}
    	}
    	if (!found) {
    		for (int j = 0; j < i; j++) {
	    		if (nums[j] > nums[i]) {
	    			res[i] = nums[j];
	    			break;
	    		}
	    	}
    	}
    	
    	if (res[i] == Integer.MIN_VALUE) res[i] = -1;
    }

    for (int i = 0; i < nums.length; i++) {
    	System.out.println(res[i]);
    }
    return res;
  }

  // Use stack
  public int[] nextGreaterElements(int[] nums) {
  	int[] res = new int[nums.length];
  	Deque<Integer> stack = new LinkedList<>();

  	for (int i = nums.length - 1; i >= 0; i--) {
  		stack.push(i);
  	}

  	for (int i = nums.length - 1; i >= 0; i--) {
  		res[i] = -1;
  		while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
  			stack.pop();

  		if (!stack.isEmpty()) {
  			res[i] = nums[stack.peek()];
  		}
  		stack.push(i);
  	}
  	return res;
  }

  public static void main(String[] args) {
  	int[] nums = {1, 2, 1};
  	Solution s = new Solution();
  	s.nextGreaterElements(nums);
  }
}