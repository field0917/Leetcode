// Given a string, sort it in decreasing order based on the frequency of characters.

// Example 1:

// Input:
// "tree"

// Output:
// "eert"

// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input:
// "cccaaa"

// Output:
// "cccaaa"

// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input:
// "Aabb"

// Output:
// "bbAa"

// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.

import java.util.*;
public class Solution {
  public String frequencySort(String s) {
    
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> charToInt = new HashMap<>();
    Map<Integer, StringBuilder> intToSB = new HashMap<>();

    char[] arr = s.toCharArray();
    for (char c : arr) {
    	charToInt.put(c, charToInt.getOrDefault(c, 0) + 1);
    }

    for (char key : charToInt.keySet()) {
    	int value = charToInt.get(key);
    	if (intToSB.containsKey(value)) {
    		intToSB.put(value, intToSB.get(value).append(key));
    	} else {
    		intToSB.put(value, new StringBuilder("" + key));
    	}
    }

    List<Integer> list = new ArrayList<>(intToSB.keySet());
    Collections.sort(list,Collections.reverseOrder());

    for (int i = 0; i < list.size(); i++) {
    	int freq = list.get(i);
    	StringBuilder charFreq = intToSB.get(freq);
    	for (int j = 0; j < charFreq.length(); j++) {
    		int m = freq;
    		while (m != 0) {
    			sb.append(charFreq.charAt(j));
    			m--;
    		}
    	}
    }
    return sb.toString();
  }

  public static void main(String[] args) {
  	String s = "Mississipi";
  	Solution sol = new Solution();

  	System.out.println(sol.frequencySort(s));
  }
}