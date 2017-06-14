// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list = new LinkedList<>();
    for (int j = 0; j < numRows; j++) {
    	List<Integer> sublist = new LinkedList<>();

    	for (int i = 0; i <= j; i++) {
    		if ((i == 0) || (i == j)) {
    			sublist.add(i, 1);
    		} else {
    			int sum = list.get(j - 1).get(i - 1) + list.get(j - 1).get(i);
    			sublist.add(i, sum);
    		}
    	}

    	list.add(j, sublist);
    }
    return list;
  }

  // Smarter solution
 	// public List<List<Integer>> generate(int numRows) {
	// 	List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	// 	ArrayList<Integer> row = new ArrayList<Integer>();

	// 	for(int i=0;i<numRows;i++) {
	// 		row.add(0, 1);
	// 		for(int j=1;j<row.size()-1;j++)
	// 			row.set(j, row.get(j)+row.get(j+1));
	// 		allrows.add(new ArrayList<Integer>(row));
	// 	}
	// 	return allrows;
	// }
}