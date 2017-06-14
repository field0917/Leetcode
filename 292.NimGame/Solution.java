public class Solution {
  public boolean canWinNim(int n) {
      if(n % 4 == 0) return false;
      else return true;
  }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.canWinNim(4));
		System.out.println(s.canWinNim(10));

	}    
}