class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }

        return maxProfit;
    }
}