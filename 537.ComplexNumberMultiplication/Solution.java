// Given two strings representing two complex numbers.

// You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

// Example 1:
// Input: "1+1i", "1+1i"
// Output: "0+2i"
// Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
// Example 2:
// Input: "1+-1i", "1+-1i"
// Output: "0+-2i"
// Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
// Note:

// The input strings will not have extra blank.
// The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.


public class Solution {
  public String complexNumberMultiply(String a, String b) {
    String[] s1 = a.split("\\+");
    String[] s2 = b.split("\\+");
    int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
  
    a1 = Integer.parseInt(s1[0]);
    b1 = Integer.parseInt(s2[0]);

    int signa = 1;
    int signb = 1;

    a2 = Integer.parseInt(s1[1].replace("i", ""));
    b2 = Integer.parseInt(s2[1].replace("i", ""));

    // for (char c : s1[1].toCharArray()) { 
    	
    // 	if (c == '-') signa = -1;
    // 	else if (c == 'i') continue;
    // 	else a2 = a2 * 10 + (c - '0');
    // }
    // a2 *= signa;

    // for (char c : s2[1].toCharArray()) {
    	
    // 	if (c == '-') signb = -1;
    // 	else if (c == 'i') continue;
    // 	else b2 = b2 * 10 + (c - '0');
    // }
    // b2 *= signb;

    // StringBuilder sb = new StringBuilder();

    // sb.append(a1 * b1 - a2 * b2);
    // sb.append('+');
    // sb.append(a1 * b2 + a2 * b1);
    // sb.append('i');

    return (a1 * b1 - a2 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
  }

  public static void main(String[] args) {
  	String a = "11+-15i";
  	String b = "4+3i";

  	Solution s = new Solution();

  	System.out.println(s.complexNumberMultiply(a, b));
  }
}