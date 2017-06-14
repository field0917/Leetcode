public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = prices[0], maxSoFar = prices[1];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxSoFar) {
                maxSoFar = prices[i];
                maxProfit = Math.max(maxProfit, maxSoFar - minSoFar);
                
            }

            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }

        }
        return maxProfit;
    }    
}
