package array.SpiralMatrix;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 */
public class SpiralOrder2 {
    public int[] spiralOrder(int[][] matrix) {
        int[] result = new int[matrix.length * matrix[0].length];
        if (matrix[0].length == 0) {
            return new int[0];
        }
        int target = matrix.length * matrix[0].length;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int count = 0;
        while (count < target) {
            for (int i = left; i <= right && count < target; i++) {
                result[count++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom && count < target; i++) {
                result[count++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && count < target; i--) {
                result[count++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top && count < target; i--) {
                result[count++] = matrix[i][left];
            }
            left++;
        }
        return result;
    }
}
