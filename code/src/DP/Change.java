package DP;

/**
 * @author MK
 * @date 2023/5/10 - 10:05
 * 518. 零钱兑换 II
 */
public class Change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.change(3, new int[]{2}));
    }
}
