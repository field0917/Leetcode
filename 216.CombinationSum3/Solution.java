// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


// Example 1:

// Input: k = 3, n = 7

// Output:

// [[1,2,4]]

// Example 2:

// Input: k = 3, n = 9

// Output:

// [[1,2,6], [1,3,5], [2,3,4]]


public class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> list = new LinkedList<>();
    combinations(list, new LinkedList<Integer>(), k, 1, n);
    return list;
  }

  private void combinations(List<List<Integer>> list, List<Integer> sublist, int k, int start, int n) {
  	if (sublist.size() == k && n != 0) return;
  	// if (sublist.size() > k || n < 0) return;
  	if (sublist.size() == k && n == 0) {
  		list.add(new LinkedList<Integer>(sublist));
  		return;
  	}

  	for (int i = start; i <= 9; i++) {
  		sublist.add(i);
  		combinations(list, sublist, k, i + 1, n - i);
  		sublist.remove(sublist.size() - 1);
  	}
  }
}