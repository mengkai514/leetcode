package DP;

import java.util.Arrays;

/**
 * @author MK
 * @date 2023/5/11 - 16:30
 * 322. 零钱兑换
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        Arrays.fill(dp, max);
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                /**
                 * 	如果钱包当前的价值j仅能允许放入一个w[i]，那么就要进行权衡，以获得更少的硬币数
                 * 		如果放入0个：此时钱包里面硬币的个数保持不变： v0=dp[j]
                 * 		如果放入1个：此时钱包里面硬币的个数为：		v1=dp[j-coins[i]]+1
                 * 		 【前提是dp[j-coins[i]]必须有值，如果dp[j-coins[i]]是无穷大，说明无法凑出j-coins[i]价值的钱包，
                 * 	              那么把w[i]放进去以后，自然也凑不出dp[j]的钱包】
                 * 	所以，此时当钱包价值为j时，里面的硬币数目为 dp[j]=min{v0,v1}
                 * 	如果钱包当前价值j能够放入2个w[i]，就要再进行一次权衡
                 * 		如果不放入第2个w[i]，此时钱包里面硬币数目为，v1=dp[j]=min{v0,v1}
                 * 		如果放入第2个w[i],  此时钱包里面硬币数目为，v2=dp[j-coins[i]]+1
                 * 	所以，当钱包的价值为j时，里面的硬币数目为dp[j]=min{v1,v2}=min{v0,v1,v2}
                 * 	钱包价值j能允许放入3个，4个.........w[i]，不断更新dp[j]，最后得到在仅使用前i个硬币的时候，每个钱包里的最少硬币数目
                 */
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2},3));
    }
}
