// Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


// American keyboard


// Example 1:
// Input: ["Hello", "Alaska", "Dad", "Peace"]
// Output: ["Alaska", "Dad"]
// Note:
// You may use one character in the keyboard more than once.
// You may assume the input string will only contain letters of alphabet.

public class Solution {
  // public String[] findWords(String[] words) {
  //   Set<Character> line1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
  //   Set<Character> line2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
  //   Set<Character> line3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
    
  //   List<String> temp = new LinkedList<>();

  //   for (String word : words) {
  //   	String lower = word.toLowerCase();
  //   	boolean flag1 = false;
  //   	boolean flag2 = false;
  //   	boolean flag3 = false;
  //   	for (int i = 0; i < word.length(); i++) {
  //   		if (line1.contains(lower.charAt(i)) && !flag2 && !flag3) {
  //   			flag1 = true;
  //   			if (i == word.length() - 1) temp.add(word);
  //   		} else if (line2.contains(lower.charAt(i)) && !flag1 && !flag3) {
  //   			flag2 = true;
  //   			if (i == word.length() - 1) temp.add(word);
  //   		} else if (line3.contains(lower.charAt(i)) && !flag1 && !flag2) {
  //   			flag3 = true;
  //   			if (i == word.length() - 1) temp.add(word);
  //   		} else break;
  //   	}
  //   }
  //   String[] res = new String[temp.size()];
  //   for (int i = 0; i < temp.size(); i++) res[i] = temp.get(i);
  //   return res;
  // }

  public String[] findWords(String[] words) {
  	String[] lines = {"qwertyuiop","asdfghjkl","zxcvbnm"};
  	List<String> temp = new LinkedList<>();
  	
  	for (String word : words) {
  		String lower = word.toLowerCase();
  		for (String line : lines) {
  			boolean find = true;
  			for (int i = 0; i < lower.length(); i++) {
  				if (!line.contains(lower.charAt(i) + "")) {
  					find = false;
  					break;
  				}
  			}
  			if (find) temp.add(word);
  		}
  	}

  	String[] res = new String[temp.size()];
    for (int i = 0; i < temp.size(); i++) res[i] = temp.get(i);
    return res;
  }
}