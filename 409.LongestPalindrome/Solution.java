// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

// This is case sensitive, for example "Aa" is not considered a palindrome here.

// Note:
// Assume the length of given string will not exceed 1,010.

// Example:

// Input:
// "abccccdd"

// Output:
// 7

// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.

public class Solution {
  public int longestPalindrome(String s) {
    boolean hasSingle = false;
    int maxLen = 0;
    int[] numLetters = new int[58];

    for (int i = 0; i < s.length(); i++) {
    	numLetters[s.charAt(i) - 'A']++;
    }

    for (int num : numLetters) {
    	if (num % 2 == 0) maxLen += num;
    	else {
    		hasSingle = true;
    		maxLen += num - 1;
    	}
    }

    return hasSingle? maxLen + 1 : maxLen;
  }

  // More clever solution:
  public int longestPalindrome(String s) {
    int count = 0;
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.charAt(i))) {
        set.remove(s.charAt(i));
        count++;
      } else {
        set.add(s.charAt(i));
      }
    }

    if (!set.isEmpty) return count * 2 + 1;
    return count * 2;
  }

  public static void main(String[] args) {
  	String s = "";
  	Solution sol = new Solution();
  	System.out.println(sol.longestPalindrome(s));
  }
}