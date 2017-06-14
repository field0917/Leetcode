// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// For example, 
// Given s = "Hello World",
// return 5.

public class Solution {
  public int lengthOfLastWord(String s) {
  	if (s == null || s.equals("")) return 0;

  	int size = s.length();
  	int len = 0;

  	while (size > 0 && s.charAt(size - 1) == ' ') size--;

  	for (int i = size - 1; i >= 0; i--) {
  		if (s.charAt(i) != ' ') len++;
  		else break;
  	}
  	return len;
  }

  public static void main(String[] args) {
  	String s = "";
  	Solution sol = new Solution();
  	System.out.println(sol.lengthOfLastWord(s));
  }
}