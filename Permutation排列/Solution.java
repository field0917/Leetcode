import java.util.*;
public class Solution {
  int num = 3;
	public List<List<Integer>> generateCombination(int n) { // From 1 -- 3, get all the Combinations of n numbers
  	List<List<Integer>> list = new LinkedList<>();
    
    boolean[] used = new boolean[num + 1];

  	helper(list, new LinkedList<Integer>(), used, n);

  	return list;
  }
  private void helper(List<List<Integer>> list, List<Integer> sublist, boolean[] used, int n) {
  	if (sublist.size() == n) {
  		list.add(new LinkedList<>(sublist));
  		return;
  	}

  	for (int i = 1; i <= num; i++) {
      if (!used[i]) {
        sublist.add(i);
        used[i] = true;
        helper(list, sublist, used, n);
        used[i] = false;
        sublist.remove(sublist.size() -1);
      } 		
  	}
  }

  public static void main(String[] args) {
  	int n = 3;
  	Solution s = new Solution();
  	System.out.println(s.generateCombination(n));
  }
}