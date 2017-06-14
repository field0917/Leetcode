// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999


// I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
public class Solution {
  public int romanToInt(String s) {
    int res = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
    	char c = s.charAt(i);
    	switch(c) {
    		case 'I':
    			res += res >= 5 ? - 1 : 1;
    			break;
    		case 'V':
    			res += 5;
    			break;
    		case 'X':
    			res += res >= 50 ? -10 : 10;
    			break;
    		case 'L':
    			res += 50;
    			break;
    		case 'C':
    			res += res >= 500 ? -100 : 100;
    			break;
    		case 'D':
    			res += 500;
    			break;
    		case 'M':
    			res += 1000;
    			break;
    	}
    }
    return res;
  }
}