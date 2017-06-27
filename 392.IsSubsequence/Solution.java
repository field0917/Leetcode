// Given a string s and a string t, check if s is subsequence of t.

// You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:
// s = "abc", t = "ahbgdc"

// Return true.

// Example 2:
// s = "axc", t = "ahbgdc"

// Return false.

// Follow up:
// If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?


public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        //------- Faster ------//
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            int idx = t.indexOf(str, start);
            if (idx == -1) return false;
            start = idx + 1;
        }
        return true;
        //--------------------//

        // int idxS = 0, idxT = 0;
        // while (idxT < t.length()) {
        //     if (s.charAt(idxS) == t.charAt(idxT)) {
        //         idxS++;
        //         if (idxS == s.length()) return true;
        //     }
        //     idxT++;
        // }
        // return false;
    }

    // Follow up:
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) return false;
            prev = binarySearch(prev, map.get(c));
            if (prev == -1) return false;
            prev++;
        }
        return true;
    }
    private int binarySearch(int index, List<Integer> list) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < index) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start == list.size() ? -1 : list.get(start);
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        Solution sol = new Solution();

        System.out.println(sol.isSubsequence(s, t));
    }
}