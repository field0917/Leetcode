// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Note: In the string, each word is separated by single space and there will not be any extra space in the string.


public class Solution {
  public String reverseWords(String s) {
    String[] strs = s.split("\\s");
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < strs.length; i++) {
    	StringBuilder newStr = new StringBuilder(strs[i]);
    	sb.append(newStr.reverse());
    	if (i != strs.length - 1) sb.append(" ");
    }
    return sb.toString();
  }

	// public void reverseWords(String s) {
 //    String[] str = s.split("\\s");
 //    for (String i : str) System.out.print(i);
 //  }

  public static void main(String[] args) {
  	String s = "Let's take LeetCode contest";
  	Solution sol = new Solution();

  	System.out.println(sol.reverseWords(s));
  }
}