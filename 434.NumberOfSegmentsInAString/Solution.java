// Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

// Please note that the string does not contain any non-printable characters.

// Example:

// Input: "Hello, my name is John"
// Output: 5

public class Solution {
  // public String[] countSegments(String s) {
  //   //if (s == null || s.length() == 0) return 0;
  //   String[] splitS = s.split(" ");
  //   return splitS;
  // }

  // public static void main(String[] args) {
  // 	Solution sol = new Solution();
  // 	String s = ", , , ,        a, eaefa";
  // 	for (int i = 0; i < s.length(); i++) {
  // 		System.out.println(i + " " + s.charAt(i));
  // 	}
  // 	String[] splitS = sol.countSegments(s);
  // 	for (int i = 0; i < splitS.length; i++) 
  // 		System.out.println(i + " " + splitS[i]);
  // }

	public int countSegments(String s) {
		if (s == null || s.length() == 0) return 0;
		String[] splitS = s.split(" ");
	  int numSeg = 0;

  	for (int i = 0; i < splitS.length; i++) {
  		if (!splitS[i].equals("")) numSeg++;
  	}
  	return numSeg;
  }

  // Use Regex
  public int countSegments(String s) {
  	if (s == null || s.trim().equals("")) return 0;
  	return s.trim().split("\\s+").length;
  }
}