package DP;

/**
 * @author MK
 * @date 2023/5/8 - 20:39
 * 474. 一和零
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int numOne, numZero;
        for (String str : strs) {
            numOne = 0;
            numZero = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    numZero++;
                } else numOne++;
            }

            for (int j = m; j >= numZero; j--) {
                for (int k = n; k >= numOne; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - numZero][k - numOne] + 1);
                    System.out.print(dp[j][k]);
                }
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();
        System.out.println(findMaxForm.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
