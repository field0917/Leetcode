// Given a set of distinct integers, nums, return all possible subsets.

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new LinkedList<>();
    if (nums == null) return list;

    int length = 0;

    while (length <= nums.length) {
    	helper(list, new LinkedList<>(), nums, length, 0);
    	length++;
    }
    
    return list;
  }
  private void helper(List<List<Integer>> list, List<Integer> sublist, int[]nums, int length, int start) {
  	if (sublist.size() == length) {
  		list.add(new LinkedList<>(sublist));
  		return;
  	}
  	for (int i = start; i < nums.length; i++) {
  		sublist.add(nums[i]);
  		helper(list, sublist, nums, length, i + 1);
  		sublist.remove(sublist.size() - 1);
  	}
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    //Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
	}
}