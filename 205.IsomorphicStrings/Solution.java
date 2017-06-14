// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

// For example,
// Given "egg", "add", return true.

// Given "foo", "bar", return false.

// Given "paper", "title", return true.

// Note:
// You may assume both s and t have the same length.
import java.util.Map;
import java.util.HashMap;

public class Solution {
 // O(n^2) because containsValue takes O(n)
  // public boolean isIsomorphic(String s, String t) {
  //   Map<Character, Character> map = new HashMap<>();
  //   Character sc, tc;
  //   for (int i = 0; i < s.length(); i++) {
  //   	sc = s.charAt(i);
  //   	tc = t.charAt(i);
  //   	if (!map.containsKey(sc)) {
  //   		if(!map.containsValue(tc)) {
  //   			map.put(sc, tc);
  //   		} else {
  //   			return false;		
  //   		}
  //   	}
  //   	else {
  //   		if (map.get(sc) != tc) return false;
  //   	}
  //   }
  //   return true;
  // }

  public boolean isIsomorphic(String s, String t) {
  	Map<Character, Integer> m1 = new HashMap<>();
  	Map<Character, Integer> m2 = new HashMap<>();

  	for (Integer i = 0; i < s.length(); i++) {
  		if (m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) return false; 
  	}
  	return true;
  }

  public static void main(String[] args) {
  	String s = "ab";
  	String t = "aa";
  	Solution sol = new Solution();
  	System.out.println(sol.isIsomorphic(s, t));
  }
}