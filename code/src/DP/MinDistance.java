package DP;

/**
 * @author MK
 * @date 2023/5/23 - 19:15
 * 583. 两个字符串的删除操作
 */
public class MinDistance {
    //只要求出两个字符串的最长公共子序列长度即可，那么除了最长公共子序列之外的字符都是必须删除的，
    // 最后用两个字符串的总长度减去两个最长公共子序列的长度就是删除的最少步数
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return len1 + len2 - dp[len1][len2] * 2;
    }
}
