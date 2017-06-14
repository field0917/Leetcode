// Shuffle a set of numbers without duplicates.

// Example:

// // Init an array with set 1, 2, and 3.
// int[] nums = {1,2,3};
// Solution solution = new Solution(nums);

// // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
// solution.shuffle();

// // Resets the array back to its original configuration [1,2,3].
// solution.reset();

// // Returns the random shuffling of array [1,2,3].
// solution.shuffle();


public class Solution {

	private int[] nums;
	
  public Solution(int[] nums) {
    this.nums = nums;
  }
  
  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return nums;
  }
  
  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] arr = nums.clone(); // use int[] arr = nums; is wrong!!!!
    Random r = new Random();

    for (int j = 1; j < arr.length; j++) {
    	int i = r.nextInt(j + 1);
    	swap(arr, i, j);
    }
    return arr;
  }

  private void swap(int[] arr, int i, int j) {
  	int temp = arr[i];
  	arr[i] = arr[j];
  	arr[j] = temp;
  	
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */