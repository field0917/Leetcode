// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Solution {
  public String countAndSay(int n) {	
    String res = "1";
  	for (int i = 0; i < n - 1; i++) {
  		StringBuilder sb = new StringBuilder();
  		int num = 1;

  		for (int j = 0; j < res.length() - 1; j++) {

  			if (res.charAt(j) == res.charAt(j + 1)) {
  				num++;
  			} else {
  				sb.append(num);
  				sb.append(res.charAt(j));
  				num = 1;
  			}
  		}

      sb.append(num).append(res.charAt(res.length() - 1));
  		res = sb.toString();

  	}
  	return res;
  }

  // public String countAndSay(int n) {
  // 	StringBuilder curr = new StringBuilder("1");
  // 	StringBuilder prev = new StringBuilder();
  // 	int count = 0;
  // 	char say = '\u0000';
  // 	for (int i = 2; i <= n; i++) {
  // 		prev = curr;
  // 		curr = new StringBuilder();
  // 		count = 1;
  // 		say = prev.charAt(0);

  // 		for (int j = 1; j < prev.length(); j++) {
  // 			if (prev.charAt(j) == say) count++;
  // 			else {  		
  // 				curr.append(count).append(say);		
  // 				say = prev.charAt(j);
  // 				count = 1;
  // 			}	
  // 		}
  // 		curr.append(count).append(say);
  // 	}
  // 	return curr.toString();
  // }

  public static void main(String[] args) {
  	int n = 9;
  	Solution s = new Solution();
  	System.out.println(s.countAndSay(n));
  }
}