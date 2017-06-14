// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

// Note:
// The vowels does not include the letter "y".
import java.util.*;
public class Solution {

	// HashSet look up time is O(1)
  // public String reverseVowels(String s) {
  // 	Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
  // 	StringBuilder sb1 = new StringBuilder();
  // 	StringBuilder sb2 = new StringBuilder();
  //   int i = 0, j = s.length() - 1;

  //   while (i <= j) {
  //   	char ic = s.charAt(i);
  //   	char jc = s.charAt(j);

  //   	if (i == j) {
  //   		sb1.append(ic);
  //   		break;
  //   	}

  //   	if (set.contains(ic) && set.contains(jc)) {
  //   		sb1.append(jc);
  //   		sb2.append(ic);
  //   		i++;
  //   		j--;
  //   	} else if (set.contains(ic) && !set.contains(jc)) {
  //   		sb2.append(jc);
  //   		j--;
  //   	} else if (!set.contains(ic) && set.contains(jc)) {
  //   		sb1.append(ic);
  //   		i++;
  //   	} else {
  //   		sb1.append(ic);
  //   		sb2.append(jc);
  //   		i++;
  //   		j--;
  //   	}
  //   }
  //   sb1.append(sb2.reverse());
  //   return sb1.toString();
  // }

  // String lookup time is O(n)
  public String reverseVowels(String s) {
  	String Vowels = "aeiouAEIOU";
  	char[] chars = s.toCharArray();
  	int start = 0, end = s.length() - 1;

  	while (start < end) {
  		while (start < end && !Vowels.contains(chars[start] + "")) {
  			start++;
  		}
  		while (start < end && !Vowels.contains(chars[end] + "")) {
  			end--;
  		}
  		char temp = chars[start];
  		chars[start] = chars[end];
  		chars[end] = temp;
  		start++;
  		end--;
  	}
  	return new String(chars);
  }

  public static void main(String[] args) {
  	String s = "Action";
  	Solution sol = new Solution();
  	System.out.println(sol.reverseVowels(s));
  }
}