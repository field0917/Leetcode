// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".

public class Solution {
  public String reverseString(String s) {

    char[] cArray = s.toCharArray();
    int start = 0;
    int end = cArray.length - 1;

    while (start < end) {
    	char temp = cArray[start];
    	cArray[start] = cArray[end];
    	cArray[end] = temp;
    	start++;
    	end--;
    }
    return new String(cArray);
  }

  public String reverseString(String s) {

    StringBuilder sb = new StringBuilder(s);
    int start = 0;
    int end = s.length() - 1;

    while (start < end) {
    	sb.setCharAt(start, s.charAt(end));
    	sb.setCharAt(end, s.charAt(start));
    	start++;
    	end--;
    }
    return sb.toString(); // All of above equals to : return new StringBuilder(s).reverse().toString();
  }
}