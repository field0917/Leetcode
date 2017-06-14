// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

import java.util.*;
public class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> al = new ArrayList<>();

    for (int i = 0; i < nums1.length; i++) {
    	if (map.containsKey(nums1[i])) {
    		map.put(nums1[i], map.get(nums1[i]) + 1);
    	} else {
    		map.put(nums1[i], 1);
    	}
    }

    for (int i = 0; i < nums2.length; i++) {
    	if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
    		al.add(nums2[i]);
    		map.put(nums2[i], map.get(nums2[i]) - 1);
    	}
    }

    int[] res = new int[al.size()];
    for (int i = 0; i < al.size(); i++) {
    	res[i] = al.get(i);
    }

    return res;
  }


  // Follow up 1: What if the given array is already sorted? How would you optimize your algorithm?
  public int[] intersect(int[] nums1, int[] nums2) {
  	int i = 0, j = 0;
  	List<Integer> al = new ArrayList<>();

  	while (i < nums1.length && j < nums2.length) {
  		if (nums1[i] < nums2[j]) i++;
  		else if (nums1[i] > nums2[j]) j++;
  		else {
  			al.add(nums1[i]);
  			i++;
  			j++;
  		}
  	}

  	// Follow up 3: What if elements of nums2 are stored on disk, and the memory is
    // limited such that you cannot load all elements into the memory at once?

  	// If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

    // If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.

  	int[] res = new int[al.size()];
    for (int i = 0; i < al.size(); i++) {
    	res[i] = al.get(i);
    }

    return res;
  }

  public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Object[] objArr = list.toArray();
	
		Integer[] empty = new Integer[list.size()];
		Integer[] intArr = list.toArray(empty);
		
		System.out.println("------Obj Array------");
		for (Object obj: objArr) {
			System.out.print(obj + " ");
		}
		System.out.println();
		System.out.println("------Int Array------");
		for (Integer i: intArr) {
			System.out.print(i + " ");
		}
	}

}