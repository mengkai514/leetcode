package DP;

/**
 * @author MK
 * @date 2023/5/5 - 15:56
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }
}
