// Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

// Example 1:
// Input: ["23:59","00:00"]
// Output: 1
// Note:
// The number of time points in the given list is at least 2 and won't exceed 20000.
// The input time is legal and ranges from 00:00 to 23:59.
import java.util.*;

public class Solution {

	// slow
  public int findMinDifference(List<String> timePoints) {
    List<Integer> time = new ArrayList<>(); // if use linkedlist<>(), time limit will be exceeded
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < timePoints.size(); i++) {
    	int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
    	int m = Integer.parseInt(timePoints.get(i).substring(3, 5));
    	time.add(h * 60 + m);
    }

    time.sort((a, b) -> a - b);

    for (int i = 1; i < time.size(); i++) {
    	int diff = time.get(i) - time.get(i - 1);
    	min = Math.min(min, diff);
    }

    int corner = time.get(0) + 1440 - time.get(time.size() - 1);
    return Math.min(min, corner);
  }

  // fast
  public int findMinDifference(List<String> timePoints) {
    boolean[] mark = new boolean[24 * 60];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < timePoints.size(); i++) {
    	String[] strs = timePoints.get(i).split(":");
    	int h = Integer.parseInt(strs[0]);
    	int m = Integer.parseInt(strs[1]);
    	if (mark[h * 60 + m]) return 0;
    	mark[h * 60 + m] = true;
    }

    int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
    int prev = 0;

    for (int i = 0; i < mark.length; i++) {
    	if (mark[i]) {
    		if (first != Integer.MAX_VALUE) {
    			min = Math.min(min, i - prev);
    		}
    		first = Math.min(first, i);
    		last = Math.max(last, i);
    		prev = i;
    	}
    }

    return Math.min(min, 24 * 60 - last + first);
  }

  // public static void main(String[] args) {
  // 	String str = "01";
  // 	int num = Integer.parseInt(str);
  // 	System.out.println(num);
  // }
}