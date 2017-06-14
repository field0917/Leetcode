// Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

// Example 1:
// Input:"-1/2+1/2"
// Output: "0/1"
// Example 2:
// Input:"-1/2+1/2+1/3"
// Output: "1/3"
// Example 3:
// Input:"1/3-1/2"
// Output: "-1/6"
// Example 4:
// Input:"5/3+1/3"
// Output: "2/1"
// Note:
// The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
// Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
// The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
// The number of given fractions will be in the range [1,10].
// The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.


public class Solution {
  public String fractionAddition(String expression) {
    List<String> nums = new LinkedList<>();

    int i = 0, j = 1;
    int len = expression.length();

    while (j <= len) {
    	if (j  == len || expression.charAt(j) == '+' || expression.charAt(j) == '-') {
    		if (expression.charAt(i) == '+') {
    			nums.add(expression.substring(i + 1, j));
    		} else {
    			nums.add(expression.substring(i, j));
    		}
    		i = j;
    	} 
    	j++;
    }

    String res = "0/1";

    for (String num : nums) {
    	res = add(res, num);
    }
    return res;
  }

  private String add(String a, String b) {
  	String[] as = a.split("/");
  	String[] bs = b.split("/");

  	int aN = Integer.parseInt(as[0]);
  	int aD = Integer.parseInt(as[1]);
  	int bN = Integer.parseInt(bs[0]);
  	int bD = Integer.parseInt(bs[1]);
  	int numer = aN * bD + bN * aD;
  	int denom = aD * bD;

  	if (numer == 0) return "0/1";

  	String sign = numer * denom < 0 ? "-" : "";
  	int n = Math.abs(numer);
  	int d = Math.abs(denom);
  	int gcd = gcd(n, d);
  	String c = sign + (n / gcd) + "/" + (d / gcd);
  	return c;
  }

  private int gcd(int a, int b) {
  	
  	if (a == 0 || b == 0) return a + b;
  	return gcd(b, a % b);
  }
}