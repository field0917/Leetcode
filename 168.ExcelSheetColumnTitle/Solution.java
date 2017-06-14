// Given a positive integer, return its corresponding column title as appear in an Excel sheet.

// For example:

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 

public class Solution {
  public String convertToTitle(int n) {
  	if (n == 0) return "";
    StringBuilder sb = new StringBuilder();

    while (n > 0) {
    	n--;
    	Character c = (char)((n % 26) + 'A');
    	sb.insert(0, c);
    	n = n / 26;
    }
    //sb.reverse();
    return sb.toString();
  }

  public static void main(String[] args) {
  	// StringBuilder sb = new StringBuilder();
  	// Character c = (char)((2 % 26) + 'A' - 1);
   //  sb.append(c);
  	// System.out.println(sb.toString());

  	int n = 26*(26*1+1)+2;
  	Solution s = new Solution();
  	System.out.println(s.convertToTitle(n));
  }
}