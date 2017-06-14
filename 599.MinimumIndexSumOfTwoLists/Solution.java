// Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

// You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

// Example 1:
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
// Output: ["Shogun"]
// Explanation: The only restaurant they both like is "Shogun".
// Example 2:
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["KFC", "Shogun", "Burger King"]
// Output: ["Shogun"]
// Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
// Note:
// The length of both lists will be in the range of [1, 1000].
// The length of strings in both lists will be in the range of [1, 30].
// The index is starting from 0 to the list length minus 1.
// No duplicates in both lists.



public class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map1 = new HashMap<>();
    //Map<String, Integer> map2 = new HashMap<>();
    int minSum = Integer.MAX_VALUE;
    List<String> list = new ArrayList<>();

    for (int i = 0; i < list1.length; i++) {
    	map1.put(list1[i], i);
    }
    // for (int i = 0; i < list2.length; i++) {
    // 	map2.put(list2[i], i);
    // }

    // for (String key : map1.keySet()) {
    // 	if (map2.containsKey(key)) {
    // 		int sum = map1.get(key) + map2.get(key);
    // 		if (sum < minSum) {
    // 			minSum = sum;
    // 			list.clear();
    // 			list.add(key);
    // 		} else if (sum == minSum) {
    // 			list.add(key);
    // 		}
    // 	}
    // }

    for (int i = 0; i < list2.length; i++) {
    	if (map1.containsKey(list2[i])) {
    		int sum = i + map1.get(list2[i]);
    		if (sum < minSum) {
    			minSum = sum;
    			list.clear();
    			list.add(list2[i]);
    		} else if (sum == minSum) {
    			list.add(list2[i];
    		}
     	}
    }

    // String[] res = new String[list.size()];

    // for (int i = 0; i < list.size(); i++) {
    // 	res[i] = list.get(i);
    // } 
    return list.toArray(new String[list.size()]);
  }
}