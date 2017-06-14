// Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

// Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

// So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

// Note:
// Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
// Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
// As long as a house is in the heaters' warm radius range, it can be warmed.
// All the heaters follow your radius standard and the warm radius will the same.
// Example 1:
// Input: [1,2,3],[2]
// Output: 1
// Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
// Example 2:
// Input: [1,2,3,4],[1,4]
// Output: 1
// Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

import java.util.*;

public class Solution {
  // public int findRadius(int[] houses, int[] heaters) {
  //   if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) return 0;

  //   Arrays.sort(houses);
  //   Arrays.sort(heaters);

  //   int i = 0, j = 0;
  //   int distance = 0;
  //   int min = Integer.MAX_VALUE;
    
  //   int res = Integer.MIN_VALUE;

  //   while (i < houses.length && j < heaters.length) {

  //   	while (j < heaters.length && houses[i] >= heaters[j]) {
  //   		distance = houses[i] - heaters[j];
  //   		min = Math.min(distance, min);
  //   		j++;
  //   	} 

  //   	if (j == heaters.length) return houses[houses.length - 1] - heaters[j - 1];

  //   	if (houses[i] < heaters[j]) {
  //   		distance = heaters[j] - houses[i];
  //   		min = Math.min(distance, min);
  //   	}
  //   	res = Math.max(res, min);
  //   	min = Integer.MAX_VALUE;
  //   	i++;
  //   	j = 0;

  //   }
  //   return res;
  // }

  // Use binary search
  public int findRadius(int[] houses, int[] heaters) {
  	Arrays.sort(heaters);

  	int res = 0;

  	for (int house : houses) {
  		int idx = Arrays.binarySearch(heaters, house);

  		if (idx < 0) idx = -(idx + 1); // idx = ~idx; is the same

  		int dist1 = idx - 1 >= 0 ? house - heaters[idx - 1] : Integer.MAX_VALUE;
  		int dist2 = idx == heaters.length ? Integer.MAX_VALUE : heaters[idx] - house;

  		res = Math.max(res, Math.min(dist1, dist2));
  	}

  	return res;
  }

  // Use one pointer
  public int findRadius(int[] houses, int[] heaters) {
  	Arrays.sort(houses);
  	Arrays.sort(heaters);

  	int i = 0;
  	int res = 0;

		for (int house : houses) {

			while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
				// heaters[i] + heaters[i + 1] <= house * 2
        // is checking if house is closer to heaters[i] or heaters[i + 1]
				// The following same function is checking if house is less than half of the two heaters
				// If it is less than half, it is closer to the heaters[i] and vice versa
				// (heaters[i] + heaters[i + 1]) / 2 <= house
				i++;
			}

			res = Math.max(res, Math.abs(house - heaters[i]));
		}
  	
  	return res;
  }


  public static void main(String[] args) {
  	int[] arr = {2,5,7,19};

  	int key = 20;

  	int idx = Arrays.binarySearch(arr, key);

  	System.out.println(idx);
  }
}