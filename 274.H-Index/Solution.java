// Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

// According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

// For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

// Note: If there are several possible values for h, the maximum one is taken as the h-index.

// Hint:

// An easy approach is to sort the array first.
// What are the possible values of h-index?
// A faster approach is to use extra space.

import java.util.*;
public class Solution {
  // O(n) time, O(n) space
  public int hIndex(int[] citations) {
  	if (citations == null || citations.length == 0) return 0;

    int len = citations.length;
    int[] arr = new int[len + 1]; // h-index is from 0 to len

    for (int i = 0; i < len; i++) {
    	if (citations[i] >= len) arr[len]++;
    	else arr[citations[i]]++;
    }

    int res = 0;

    for (int i = len; i >= 0; i--) {
    	res += arr[i];
    	if (res >= i) return i;
    }
    return 0;
    
  }

  // O(nlgn) time, O(1) space
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int len = citations.length;

    // for (int i = len - 1; i >= 0; i--) {
    //   if (citations[len - i - 1] >= i + 1) return i + 1;
    // }
    // return 0;

    for (int i = 0; i < len; i++) {
      if (citations[i] >= len - i) return len - i;
    }
    return 0;
  }

  public static void main(String[] args) {
  	int[] citations = {0,1,2,8,9};
  	Solution s = new Solution();
  	System.out.println(s.hIndex(citations));
  }
}