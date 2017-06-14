// Given an integer, return its base 7 string representation.

// Example 1:
// Input: 100
// Output: "202"
// Example 2:
// Input: -7
// Output: "-10"
// Note: The input will be in range of [-1e7, 1e7].


public class Solution {
  public String convertToBase7(int num) {
    StringBuilder sb = new StringBuilder();

    String sign = num >= 0 ? "" : "-";
    num = Math.abs(num);

    while (num >= 7) {
    	sb.append(num % 7);
    	num /= 7;
    }

    sb.append(num);
    sb.append(sign);

    return sb.reverse().toString();
  }
}