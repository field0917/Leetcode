// Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

// Example 1:
// Input: [3, 2, 1]

// Output: 1

// Explanation: The third maximum is 1.
// Example 2:
// Input: [1, 2]

// Output: 2

// Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
// Example 3:
// Input: [2, 2, 3, 1]

// Output: 1

// Explanation: Note that the third maximum here means the third maximum distinct number.
// Both numbers with value 2 are both considered as second maximum.

public class Solution {

	// This solution is not ideal, it's not easily modifiable
	// for example if you want to find 7th maximum instead of 3rd.
	// See the solution using priority queue
  public int thirdMax(int[] nums) {
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);

    Integer fst = null, scd = null, thd = null;

    for (Integer num : nums) {
    	if (num.equals(fst) || num.equals(scd) || num.equals(thd)) continue;
    	if (fst == null || num > fst) {
    		thd = scd;
    		scd = fst;
    		fst = num;    		
    	} else if (scd == null || num > scd) {
    		thd = scd;
    		scd = num;    		
    	} else if (thd == null || num > thd) {
    		thd = num;
    	}
    }

    return thd == null ? fst : thd;
  }

  // RIGHT BUT BAD ANSWER
  // public int thirdMax(int[] nums) {
  //   if (nums.length == 1) return nums[0];
  //   if (nums.length == 2) return Math.max(nums[0], nums[1]);

  //   long fst = (long)Integer.MIN_VALUE - 1, scd = (long)Integer.MIN_VALUE - 1, thd = (long)Integer.MIN_VALUE - 1;

  //   for (int num : nums) {
  //   	if (num == fst || num == scd || num == thd) continue;
  //   	if (num > fst) {
  //   		thd = scd;
  //   		scd = fst;
  //   		fst = num;    		
  //   	} else if (num > scd) {
  //   		thd = scd;
  //   		scd = num;    		
  //   	} else if (num > thd) {
  //   		thd = num;
  //   	}
  //   }

  //   return thd == (long)Integer.MIN_VALUE - 1 ? (int)fst : (int)thd;
  // }

  // Use priority queue 
  public int thirdMax(int[] nums) {
  	PriorityQueue<Integer> pq = new PriorityQueue<>();

  	for (int n : nums) {
  		if (!pq.contains(n)) {
  			pq.offer(n);
  			if (pq.size() > 3) pq.poll();
  		}
  	}
  	if (pq.size() == 2) pq.poll();

  	return pq.peek();
  }

  public static void main(String[] args) {
  	int[] nums = {3, 2, 1};
  	Solution s = new Solution();

  	System.out.println(s.thirdMax(nums));
  }
}