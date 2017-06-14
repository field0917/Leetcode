// Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

// Note:

// The length of both num1 and num2 is < 5100.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.

public class Solution {
  public String addStrings(String num1, String num2) {

  	int carry = 0;
  	int digit = 0;
  	StringBuilder sb = new StringBuilder();

  	for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
  		int d1 = i < 0 ? 0 : num1.charAt(i) - '0';
  		int d2 = j < 0 ? 0 : num2.charAt(j) - '0';
  		digit = (d1 + d2 + carry) % 10;
  		carry = (d1 + d2 + carry) / 10;
  		sb.append(digit);
  	}
  	return sb.reverse().toString();
	}
}