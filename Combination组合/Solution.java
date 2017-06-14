import java.util.*;
public class Solution {
	public List<List<Integer>> generateCombination(int n) { // From 0 -- 9, get all the Combinations of n numbers
  	List<List<Integer>> list = new LinkedList<>();

  	helper(list, new LinkedList<Integer>(), n, 0);

  	return list;
  }
  private void helper(List<List<Integer>> list, List<Integer> sublist, int n, int start) {
  	if (sublist.size() == n) {
  		list.add(new LinkedList<>(sublist));
  		return;
  	}

  	for (int i = start; i <= 9; i++) {
  		sublist.add(i);
  		helper(list, sublist, n, i + 1);
  		sublist.remove(sublist.size() -1);
  	}
  }

  public static void main(String[] args) {
  	int n = 3;
  	Solution s = new Solution();
  	System.out.println(s.generateCombination(n));
  }
}