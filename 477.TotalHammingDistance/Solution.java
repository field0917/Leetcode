// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

// Now your job is to find the total Hamming distance between all pairs of the given numbers.

// Example:
// Input: 4, 14, 2

// Output: 6

// Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
// showing the four bits relevant in this case). So the answer will be:
// HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
// Note:
// Elements of the given array are in the range of 0 to 10^9
// Length of the array will not exceed 10^4.


public class Solution {
	// Too too too too too SLOW!!!!
  // public int totalHammingDistance(int[] nums) {
  // 	int distance = 0;
   	

  //   for (int i = 0; i < nums.length; i++) {    	
    	
  //   	for (int j = i + 1; j < nums.length; j++) {
  //   		int n = 1;
  //   		int nbits = 0;
  //   		while (nbits < 32) {
  //   			if ((nums[i] & n) != (nums[j] & n)) distance++;
  // 				nbits++;
  //   			n <<= 1;
    			
  //   		}   		
  //   	}
  //   }
  //   return distance;
  // }

	public int totalHammingDistance(int[] nums) {
		int bitCount = 0; // num of 1 bit in that particular position, so (n - bitCount) of 0 bit in that position
		int n = nums.length;
		int distance = 0;

		for (int i = 0; i < 32; i++) {
			bitCount = 0;
			for (int j = 0; j < n; j++) {
				if (((nums[j] >> i) & 1) == 1) bitCount++; // bitCount += (nums[j] >> 1) & 1;
			}
			distance += bitCount * (n - bitCount);
		}
		return distance;
	}

  public static void main(String[] args) {
  	int[] nums = {4, 14, 2};
  	Solution s = new Solution();
  	System.out.println(s.totalHammingDistance(nums));
  }
}