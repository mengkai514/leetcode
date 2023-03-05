package array.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder2(matrix)); //行
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int count = 1;
        int target = matrix.length * matrix[0].length;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> list = new ArrayList();
        while (count <= target) {
            for (int i = left; i <= right && count <= target; i++) {
                list.add(matrix[top][i]);
                count++;
            }
            top++;
            for (int i = top; i <= bottom && count <= target; i++) {
                list.add(matrix[i][right]);
                count++;
            }
            right--;
            for (int i = right; i >= left && count <= target; i--) {
                list.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top && count <= target; i--) {
                list.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return list;
    }

    //解法2
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] visited = new boolean[row][column];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0, currentDir = 0;
        int count = 1;
        while (count <= column * row){
            list.add(matrix[i][j]);
            visited[i][j] = true;
            int NewI = i + directions[currentDir][0];
            int NewJ = j + directions[currentDir][1];
            if (NewI >= row || NewI < 0 || NewJ < 0 || NewJ >= column || visited[NewI][NewJ]){
                currentDir = (currentDir + 1) % 4;
            }
            i = i + directions[currentDir][0];
            j = j + directions[currentDir][1];
            count++;
        }
        return list;
    }
}
