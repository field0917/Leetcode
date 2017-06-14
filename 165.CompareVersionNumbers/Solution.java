// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

// Here is an example of version numbers ordering:

// 0.1 < 1.1 < 1.2 < 13.37

public class Solution {
  public int compareVersion(String version1, String version2) {
    if (version1.length() == 0 || version2.length() == 0) return 0;

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int len = Math.max(v1.length, v2.length);

    for (int i = 0; i < len; i++) {
    	int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
    	int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

    	if (n1 > n2) return 1;
    	else if (n1 < n2) return -1;
    	else continue;
    }
    return 0;
  }

  public static void main(String[] args) {
  	String version1 = "1.12";
  	String version2 = "1.12.3.4";
  	// String[] v1 = version1.split(".");
   //  String[] v2 = version2.split(".");

   //  for (int i = 0; i < v1.length; i++) {
   //  	System.out.println("v1 array: " + v1[i]);
   //  }
  	Solution s = new Solution();

  	System.out.println(s.compareVersion(version1, version2));
  }

  // 2nd time
  // Notice 1.0 and 1 are equal
  public int compareVersion(String version1, String version2) {
    if (version1.length() == 0 || version2.length() == 0) return 0;

    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int len = Math.max(v1.length, v2.length);

    for (int i = 0; i < len; i++) {
      int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
      int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
      if (n1 < n2) return -1;
      if (n1 > n2) return 1;
    }

    return 0;
  }
}