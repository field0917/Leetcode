// Implement int sqrt(int x).

// Compute and return the square root of x.

public class Solution {
  public int mySqrt(int x) {
  	if (x == 0) return 0;
    int start = 1;
    int end = Integer.MAX_VALUE;
    

    while (true) {
    	int mid = start + (end - start) / 2;
    	if (mid > x / mid) { // why cannot use mid * mid > x ???? Because mid * mid may overflow
    		end = mid - 1;
    	} else {
    		if ((mid + 1) > x / (mid + 1)) // why cannot use (mid + 1) * (mid + 1) > x ????
    			return mid;
    		start = mid + 1;
    	}
    }
  }

  public static void main(String[] args) {
  	int x = 1;
  	Solution s = new Solution();
  	System.out.println(s.mySqrt(x));
  }
}