package DP;

import java.util.Arrays;

/**
 * @author MK
 * @date 2023/5/12 - 10:03
 * 279. 完全平方数
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int[] weight = new int[(int) Math.sqrt(n)];
        int count = 0;
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            if (i * i <= n) {
                weight[count++] = i * i;
            }
        }
        for (int i = 0; i < count; i++) {
            for (int j = weight[i]; j <= n; j++) {
                if (dp[j - weight[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(9));
    }
}
