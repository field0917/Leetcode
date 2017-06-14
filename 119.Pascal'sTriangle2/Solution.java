// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?

public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new LinkedList<>();

    for (int j = 0; j <= rowIndex; j++) {
    	row.add(0, 1);

    	for (int i = 1; i < row.size()-1; i++) {
    		row.set(i, row.get(i) + row.get(i + 1));
    	}
    }
    return row;
  }
}