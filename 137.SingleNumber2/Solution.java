// Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Solution {
	// Count the number of ones of each bit respectively, if %3==1, single number got a 1 on that bit
  public int singleNumber(int[] nums) {
		int res = 0;
		

		for (int i = 0; i < 32; i++) {
			int sumOnes = 0;
			int mask = 1 << i;

			for (int num : nums) {
				if ((num & mask) == mask) {
					sumOnes++;
				}
			}
			res |= ((sumOnes % 3) << i);
		}
		return res;
	}

	//
	public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for(int i = 0; i < A.length; i++){
        ones = (ones ^ A[i]) & ~twos;
        twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
	}

}