// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
// Example:

// prices = [1, 2, 3, 0, 2]
// maxProfit = 3
// transactions = [buy, sell, cooldown, buy, sell]



// buy[i] : Maximum profit which end with buying on day i or end
// with buying on a day before i and takes rest until the day i since then.

// sell[i] : Maximum profit which end with selling on day i or end
// with selling on a day before i and takes rest until the day i since then.

public class Solution {
	//Draw a Finite State Machine is easier to understand
	public int maxProfit(int[] prices) {
  	if (prices == null || prices.length == 0) return 0;

 		int s0 = 0, b0 = -prices[0], r0 = 0;

 		for (int price : prices) {
 			
 			int preS0 = s0;
 			s0 = b0 + price;
 			b0 = Math.max(b0, r0 - price);
 			r0 = Math.max(r0, preS0);

 		}
  	return Math.max(s0, r0);
  }

  public int maxProfit(int[] prices) {
  	if (prices == null || prices.length == 0) return 0;

  	int b0 = -prices[0], b1 = b0;// b1 is buy[i-1], b0 is buy[i]
  	int s0 = 0, s1 = 0, s2 = 0; // s0 is sell[i], s1 is sell[i-1], s2 is sell[i-2]
  	for (int price : prices) {
  		b0 = Math.max(b1, s2 - price);
  		s0 = Math.max(s1, b1 + price);
  		b1 = b0;
  		s2 = s1;
  		s1 = s0;
  	}
  	return s0;
  }
}