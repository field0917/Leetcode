// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?

public class Solution {
  // public boolean isAnagram(String s, String t) {
  // 	if(s.length() != t.length()) return false;
  // 	final int NUM_LETTER = 26;
  // 	int[] arr = new int[NUM_LETTER];
  // 	for(int i = 0; i < s.length(); i++) {
  // 		arr[s.charAt(i) - 'a']++;
  // 	}
  // 	for(int j = 0; j < t.length(); j++) {
  // 		arr[t.charAt(j) - 'a']--;
  // 	}
  // 	for(int k = 0; k < NUM_LETTER; k++) {
  // 		if(arr[k] != 0) return false;
  // 	}
  // 	return true;
  // }

  // Follow up
  public boolean isAnagram(String s, String t) {
  	if(s.length() != t.length()) return false;
  	Map<Character, Integer> hm = new HashMap<>();
  	int len = s.length();

  	for(int i = 0; i < len; i++) {
  		Character c = s.charAt(i);
  		if(hm.containsKey(c)) {
  			hm.put(c, hm.get(c) + 1);
  		} else {
  			hm.put(c, 1);
  		}
  	}

  	for(int j = 0; j < len; j++) {
  		Character c = t.charAt(j);
  		if(hm.containsKey(c)) {
  			hm.put(c, hm.get(c) - 1);
  			hm.remove(c, 0);
  		} else {
  			return false;
  		}
  	}
  	return hm.size() == 0;
  }
}