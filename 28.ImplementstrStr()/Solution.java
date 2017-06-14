// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class Solution {
	// This is to implement haystack.indexOf(needle)
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) return -1;
    int i = 0;
    int j = 0;
    while (i < haystack.length() && j < needle.length()) {
    	if (haystack.charAt(i) == needle.charAt(j)) {
    		i++;
    		j++;
    	} else {
    		if (j != 0) {
    			i = i - j + 1;
    			j = 0; 
    		}
    		else i++;
    	}
    }
    return j == needle.length() ? i - needle.length() : -1;
  }

  // Another solution:
  public int strStr(String haystack, String needle) {
  	for (int i = 0;; i++) {
  		for (int j = 0;; j++) {
  			if (j == needle.length()) return i;
  			if (i + j == haystack.length()) return -1;
  			if (haystack.charAt(i + j) != needle.charAt(j)) break;
  		}
  	}
  }
}