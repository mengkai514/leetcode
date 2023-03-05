package array.SpiralMatrix;

/**
 * 59. 螺旋矩阵 II
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 1 , end = n * n;
        int left = 0 , bottom = n - 1 , right = n - 1 ,top = 0;
        while (start <= end) {
            for (int i = left; i <= right; i++) { //From left to right
                result[top][i] = start++;
            }
            top++;
            for (int i = top; i <= bottom ; i++) { //From top to bottom
                result[i][right] = start++;
            }
            right--;
            for (int i = right; i >= left; i--) { //From right to left
                result[bottom][i] = start++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--){ //From bottom to top
                result[i][left] = start++;
            }
            left++;
        }
        return result;
    }
}
