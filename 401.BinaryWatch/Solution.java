// A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

// Each LED represents a zero or one, with the least significant bit on the right.


// For example, the above binary watch reads "3:25".

// Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

// Example:

// Input: n = 1
// Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
// Note:
// The order of output does not matter.
// The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
// The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

public class Solution {
  
  String[][] hours = {{"0"},  // hours contains 0 1's
			   {"1", "2", "4", "8"},   // hours contains 1 1's
			   {"3", "5", "6", "9", "10"},  // hours contains 2 1's
			   {"7", "11"}};  // hours contains 3 1's
	String[][] minutes = {{"00"},  // mins contains 0 1's
		             {"01", "02", "04", "08", "16", "32"},  // mins contains 1 1's
		             {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},  // mins contains 2 1's
		             {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},  // mins contains 3 1's
		             {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},  // mins contains 4 1's
		             {"31", "47", "55", "59"}};  // mins contains 5 1's

	public List<String> readBinaryWatch(int num) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i <= 3 && i <= num; i++) {
			if (num - i <= 5) {
				for (String str1 : hours[i]) {
					for (String str2 : minutes[num - i]) {
						list.add(str1 + ":" + str2);
					}
				}
			}
		}
		return list;
  }

  // Use Integer.bitCount()
  public List<String> readBinaryWatch(int num) {
  	List<String> list = new ArrayList<>();

  	for (int h = 0; h < 12; h++) {
  		for (int m = 0; m < 60; m++) {
  			if (Integer.bitCount(h << 6 + m) == num) {
  				list.add(String.format("%d:%02d",h,m));
  			}
  		}
  	}
  	return list;
  }

  // Backtracking
  public List<String> readBinaryWatch(int num) {
  	List<String> list = new ArrayList<>();
  	int[] nums1 = {8, 4, 2, 1};
  	int[] nums2 = {32, 16, 8, 4, 2, 1};

  	for (int i = 0; i <= num; i++) {
  		List<Integer> list1 = generateDigit(nums1, i);
  		List<Integer> list2 = generateDigit(nums2, num - i);

  		for (int num1 : list1) {
  			if (num1 >= 12) continue;
  			for (int num2 : list2) {
  				if (num2 >= 60) continue;
  				list.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
  			}
  		}
  	}
  	return list;
  }

  private List<Integer> generateDigit(int[] nums, int count) {
  	List<Integer> list = new ArrayList<>();
  	generateDigitHelper(list, count, 0, 0, nums);
  	return list;
  }

  private void generateDigitHelper(List<Integer> list, int count, int position, int sum, int[] nums) {
  	if (count == 0) {
  		list.add(sum);
  		return;
  	}

  	for (int i = position; i < nums.length; i++) {
  		generateDigitHelper(list, count - 1, i + 1, sum + nums[i], nums);
  	}
  }
}