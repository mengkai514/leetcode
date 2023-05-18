package DP;

/**
 * @author MK
 * @date 2023/5/18 - 19:58
 * 188. 买卖股票的最佳时机 IV
 */
public class MaxProfitIV {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i <= 2 * k; i++) {
            if (i % 2 == 0) {
                dp[0][i] = 0;
            } else dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 0) {
                    dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1] + prices[i]);
                } else dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1] - prices[i]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }

    public static void main(String[] args) {
        MaxProfitIV maxProfitIV = new MaxProfitIV();
        System.out.println(maxProfitIV.maxProfit(2,new int[]{3,2,6,5,0,3}));
    }
}