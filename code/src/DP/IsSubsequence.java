package DP;

/**
 * @author MK
 * @date 2023/5/22 - 17:13
 * 392. 判断子序列
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= s.length() ; i++) {
            char char1 = s.charAt(i - 1);
            for (int j = 1; j <= t.length(); j++) {
                char char2 = t.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
