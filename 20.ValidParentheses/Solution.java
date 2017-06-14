// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
  public boolean isValid(String s) {
    if (s.length() % 2 != 0) return false;

    Deque<Character> stack = new LinkedList<>();
    stack.push(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
  
    	Character next = s.charAt(i);
    	
    	if (!stack.isEmpty()) {
    		Character curr = stack.peek();
    		if ((next - curr > 0) && (next - curr < 3)) {
    			stack.pop();
    		} else {
    			stack.push(next);
    		}
    	} else stack.push(next);
    	
    }

    return stack.isEmpty();
  }

 	public static void main(String[] args) {
 		String s = "()";
 		Solution sol = new Solution();
 		System.out.println(sol.isValid(s));
 	}

}