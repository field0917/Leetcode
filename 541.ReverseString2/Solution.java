// Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
// Example:
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
// Restrictions:
// The string consists of lower English letters only.
// Length of the given string and k will in the range [1, 10000]


public class Solution {
  public String reverseStr(String s, int k) {
    StringBuilder res = new StringBuilder();
    int len = s.length();

    for (int i = 0; i < len; i = i + 2 * k) {
    	StringBuilder sb = new StringBuilder();
    	if (len - i < k) {
    		sb.append(s.substring(i, len)).reverse();
	    } else if (len - i < 2 * k) {
	    	sb.append(s.substring(i, i + k)).reverse();
	    	sb.append(s.substring(i + k, len));
	    } else {
	    	sb.append(s.substring(i, i + k)).reverse();
	    	sb.append(s.substring(i + k, i + 2 * k));
	    }
	    res.append(sb);
    }
	  return res.toString();
  }

  public static void main(String[] args) {
  	String s = "abcdefg";
  	int k = 1;

  	Solution sol = new Solution();

  	System.out.println(sol.reverseStr(s, k));
  }
}