// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


public class Solution {

	// Bucked sort
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer>[] bucked = new List[nums.length + 1];
    Map<Integer, Integer> numToFreq = new HashMap<>();

    for (int n : nums) {
    	numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
    }

    for (int key : numToFreq.keySet()) {
    	int freq = numToFreq.get(key);
    	if (bucked[freq] == null) bucked[freq] = new ArrayList<>();

    	bucked[freq].add(key);
    }

    List<Integer> res = new ArrayList<>();
    for (int i = nums.length; i >= 0 && res.size() < k; i--) {
    	if (bucked[i] == null) continue;
    	res.addAll(bucked[i]);
    }
    //return res;

    //return res.subList(0, k);
//     Think about the case when K=2,
// and you have 1 number that has max frequency, say 10 times.
// and you have 10 numbers that has 2nd max frequency, say 9 times.
// With your algo, the returned list will contain 11 numbers instead of 2.

// Any easy fix:
// return res.subList(0,k);

// (It seems the above scenario is not covered by the existing test cases.)
  }

  // MaxHeap
  public List<Integer> topKFrequent(int[] nums, int k) {
  	Map<Integer, Integer> hm = new HashMap<>();

  	for (int n : nums) {
  		hm.put(n, hm.getOrDefault(n, 0) + 1);
  	}

  	PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
  	for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
  		maxHeap.add(entry);
  	}

  	List<Integer> res = new ArrayList<>();

  	while (res.size() < k) {
  		res.add(maxHeap.poll().getKey());
  	}
  	return res;
  }

}