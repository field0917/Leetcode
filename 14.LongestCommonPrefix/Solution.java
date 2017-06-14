// Write a function to find the longest common prefix string amongst an array of strings.
import java.util.Arrays;

public class Solution {
  public String longestCommonPrefix(String[] strs) {
  	if (strs == null || strs.length == 0) return "";
    StringBuilder res = new StringBuilder();

    Arrays.sort(strs);
    String first = strs[0];
    String last = strs[strs.length - 1];
    
    int len = Math.min(first.length(), second.length());

    for (int i = 0; i < len; i++) {
    	if (first.charAt(i) != last.charAt(i)) return res.toString();
    	res.append(first.charAt(i));
    }
    return res.toString();
  }
}