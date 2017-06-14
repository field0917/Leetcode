// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.
import java.util.*;

public class Solution {
  public int[] plusOne(int[] digits) {
    int end = digits.length - 1;

    for(int i = end; i >= 0; i--) {
    	if(digits[i] < 9) {
    		digits[i] += 1;
    		return digits;
    	} 
  		digits[i] = 0;	
    }

    int[] newDigits = new int[digits.length + 1];
    newDigits[0] = 1;

    return newDigits;
  }

  public static void main(String[] args) {
  	int[] digits = {9,9};
  	Solution s = new Solution();
  	int[] res = s.plusOne(digits);
  	System.out.println(Arrays.toString(res));
  }
}