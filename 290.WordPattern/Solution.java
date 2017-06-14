// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

// Examples:
// pattern = "abba", str = "dog cat cat dog" should return true.
// pattern = "abba", str = "dog cat cat fish" should return false.
// pattern = "aaaa", str = "dog cat cat dog" should return false.
// pattern = "abba", str = "dog dog dog dog" should return false.
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
import java.util.Map;
import java.util.HashMap;

public class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] splitedStr = str.split(" ");
    if (pattern.length() != splitedStr.length) return false;

    Map<Character, String> hm = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
    	Character a = pattern.charAt(i);
    	String b = splitedStr[i];
    	if (hm.containsKey(a)) {
    		if (!hm.get(a).equals(b)) return false;
    	} else {
    		if (hm.containsValue(b)) return false;
    		else hm.put(a, b);
    	}
    }
    return true;
  }

  public static void main(String[] args) {
  	String pattern = "abcb";
  	String str = "egg box bun dog";
  	Solution s = new Solution();
  	System.out.println(s.wordPattern(pattern, str));
  }
}