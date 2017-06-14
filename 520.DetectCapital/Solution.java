// Given a word, you need to judge whether the usage of capitals in it is right or not.

// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital if it has more than one letter, like "Google".
// Otherwise, we define that this word doesn't use capitals in a right way.
// Example 1:
// Input: "USA"
// Output: True
// Example 2:
// Input: "FlaG"
// Output: False
// Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


public class Solution {
  // public boolean detectCapitalUse(String word) {

  //   boolean firstUppercase = false;
  //   boolean allLowercase = false;
  //   boolean allUppercase = false;
  //   boolean oneUppercase = false;

  //   for (int i = 0; i < word.length(); i++) {
  //   	char c = word.charAt(i);
  //   	if (c == Character.toLowerCase(c) && (i == 0)) {
  //   		allLowercase = true;
  //   	} else if (c != Character.toLowerCase(c) && (i == 0)) {
  //   		firstUppercase = true;
  //   	} else if (firstUppercase && c == Character.toLowerCase(c) && (i == 1)) {
  //   		oneUppercase = true;
  //   	} else if (firstUppercase && c != Character.toLowerCase(c) && (i == 1)) {
  //   		allUppercase = true;
  //   	}


  //   	if (allLowercase && c != Character.toLowerCase(c)) return false;
  //   	if (oneUppercase && c != Character.toLowerCase(c)) return false;
  //   	if (allUppercase && c == Character.toLowerCase(c)) return false;
  //   }
  //   return true;
  // }

  // Much shorter solution
	public boolean detectCapitalUse(String word) {
		if (word.length() < 2) return true;
		if (word.toUpperCase().equals(word)) return true;
		if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
		return false;
	}

	// Regex
	public boolean detectCapitalUse(String word) {
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}

}