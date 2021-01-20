https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length ; i++) {
            if (prev < prices[i]) {
                sum = sum + (prices[i] - prev);
            }
            prev = prices[i];
        }
        return sum;
    }
}