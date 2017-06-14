// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class Solution {
  public String convert(String s, int numRows) {
  	if (s == null || s.length() == 0) return "";
  	if (numRows == 1) return s;

    ArrayList<ArrayList<Character>> al = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
    	al.add(i, new ArrayList<Character>());
    }
    StringBuilder sb = new StringBuilder();
    int row = 0;
    boolean upflag = false;

    for (int i = 0; i < s.length(); i++) {   	
    	al.get(row).add(s.charAt(i));
    	
    	if (row == numRows - 1) upflag = true;
    	if (row == 0) upflag = false;
    	if (!upflag) row++;
    	if (upflag) row--;

    }

    for (int i = 0; i < numRows; i++) {
    	for (int j = 0; j < al.get(i).size(); j++) {
    		sb.append(al.get(i).get(j));
    	}
    }
    return sb.toString();
  }

  // Another solution:
  public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
    
    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
  }

    // 2nd time
    // Some problems : 1. Notice when numRows == 1   2. Initialize array of StringBuilder
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int row = 0;
        int step = 0;

        for (int i = 0; i < s.length(); i++) {
            if (row == numRows - 1) step = -1;
            if (row == 0) step = 1;
            sb[row].append(s.charAt(i));
            row += step;
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}