// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.
// Note: You may assume the string contain only lowercase letters.

public class Solution {
	// Use map
  public int firstUniqChar(String s) {
  	if (s.length() == 0) return -1;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
    	if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), -1);
    	else map.put(s.charAt(i), i);
    }

    int minIdx = Integer.MAX_VALUE;

    for (Character key : map.keySet()) {
    	if (map.get(key) > -1 && map.get(key) < minIdx) minIdx = map.get(key);
    }
    if (minIdx == Integer.MAX_VALUE) minIdx = -1;
    return minIdx;
  }

  // Use array
  public int firstUniqChar(String s) {
  	int[] freq = new int[26];

  	for (int i = 0; i < s.length(); i++) {
  		freq[s.charAt(i) - 'a']++;
  	}

  	for (int i = 0; i < s.length(); i++) {
  		if (freq[s.charAt(i) - 'a'] == 1) return i;
  	}
  	return -1;
  }
}