package Greedy;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int result = 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1][1] < points[i][0]) {
                result++;
            } else {
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return result;
    }
}
