// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

public class Solution {
  // public int myAtoi(String str) {
  //   if (str.length() == 0) return 0;
  //   // 1. Remove white spaces
  //   int idx = 0;
  //   while (str.charAt(idx) == ' ' && idx < str.length())
  //   	idx++;
  //   // 2. Handle signs
  //   int sign = 1;
  //   if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
  //   	sign = str.charAt(idx) == '+' ? 1 : -1;
  //   	idx++;
  //   }
  //   // 3. Convert number and avoid overflow
  //   int result = 0;
  //   for (; idx < str.length(); idx++) {
  //   	Character c = str.charAt(idx);
  //   	if (!Character.isDigit(c)) break;
  //   	else {
  //   		int digit = Character.getNumericValue(c);

  //   		if ((Integer.MAX_VALUE - digit) / 10 < result)
  //   			return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;

  //   		result = result * 10 + digit;

  //   	}
  //   }
  //   return result * sign;
  // }

  public static void main(String[] args) {
  	// char c = '3';
  	// System.out.println(Character.getNumericValue(c));

  	//String str = "  -0024a56"; // should return -24
    String str = "  -+1"; // should return 0;
  	Solution s = new Solution();
  	System.out.println(s.myAtoi(str));
  }

  // 2nd time
  // First discard leading and trailing white space
  // Second get the sign, there should be only one sign or no sign. multiple sign is not valid, return 0.
  // If there is any non-digital char in the string, break the loop and return the res;
  public int myAtoi(String str) {
    str = str.trim();

    if (str.length() == 0) return 0;

    int res = 0;
    int sign = 1;
    int idx = 0;

    if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
      sign = str.charAt(idx) == '+' ? 1 : -1;
      idx++;
    }

    for (; idx < str.length(); idx++) {
      char c = str.charAt(idx);
      if (!Character.isDigit(c)) break;
      int digit = Character.getNumericValue(c);
      if ((Integer.MAX_VALUE - digit) / 10 < res)
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

      res = res * 10 + digit;
    }
    return sign * res;
  }
}