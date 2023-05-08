package DP;

/**
 * @author MK
 * @date 2023/5/8 - 10:50
 * 1049. 最后一块石头的重量 II
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 分割成两个尽可能相近的子集，(sum - dp[target])--剩余大小
        //在计算target的时候，target = sum / 2 因为是向下取整，所以sum - dp[target] 一定是大于等于dp[target]的。
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return (sum - dp[target]) - dp[target];
    }

    public static void main(String[] args) {
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        System.out.println(lastStoneWeightII.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
