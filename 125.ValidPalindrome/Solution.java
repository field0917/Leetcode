// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.

public class Solution {
	// Using Regex
  // public boolean isPalindrome(String s) {
  //   if (s.length() == 0) return true;

  //   s = s.replaceAll("[^A-Za-z0-9]", "");
  //   s = s.toLowerCase();

  //   for (int i = 0; i <= s.length() - 1 - i; i++) {
  //   	if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
  //   }
  //   return true;
  // }

  // Using Character method isLetterOrDigit()  ---> faster
  public boolean isPalindrome(String s) {
  	int head = 0;
  	int tail = s.length() - 1;

  	while (head < tail) {
  		Character chead = s.charAt(head);
  		Character ctail = s.charAt(tail);
  		if (!Character.isLetterOrDigit(chead)) head++;
  		else if (!Character.isLetterOrDigit(ctail)) tail--;
  		else {
  			if (Character.toLowerCase(chead) != Character.toLowerCase(ctail)) return false;
  			head++;
  			tail--;
  		}
  	}
  	return true;
  }

  public static void main(String[] args) {
  	String s = "A man, a plan, a canal: Panama";
  	Solution sol = new Solution();

  	System.out.println(sol.isPalindrome(s));
  }
}