// Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

// Example 1:
// Input: "abab"

// Output: True

// Explanation: It's the substring "ab" twice.
// Example 2:
// Input: "aba"

// Output: False
// Example 3:
// Input: "abcabcabcabc"

// Output: True

// Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


public class Solution {
  public boolean repeatedSubstringPattern(String str) {
    int idx = 0;
    int lenS = str.length();
    String subS = "";
    int lenSub = 0;
    boolean flag = false;

    while ((idx < lenS/2) && !flag) {
    	subS += str.charAt(idx);
    	lenSub = subS.length();
    	flag = true;
    	if (lenS % lenSub == 0) {
    		for (int i = idx + 1; i < lenS; i = i + lenSub) {
    			if (!subS.equals(str.substring(i, i + lenSub))) {
    				flag = false;
    				break;
    			}
    		}
    	} else {
    		flag = false;
    	}   	
    	idx++;
    }
    return flag;
  }

  // Another Similar Solution:
  public boolean repeatedSubstringPattern(String str) {
    int len = str.length();
  	for(int i=len/2 ; i>=1 ; i--) {
  		if(len%i == 0) {
  			int m = len/i;
  			String subS = str.substring(0,i);
  			int j;
  			for(j=1;j<m;j++) {
  				if(!subS.equals(str.substring(j*i,i+j*i))) break;
  			}
  			if(j==m)
  			    return true;
  		}
  	}
  	return false;
  }

  public static void main(String[] args) {
  	String str = "ababab";
  	Solution s = new Solution();
  	System.out.println(s.repeatedSubstringPattern(str));
  }
}