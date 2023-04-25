package Greedy;

import java.util.Arrays;

/**
 * @author MK
 * @date 2023/4/24 - 14:50
 * 435. 无重叠区间
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        // 从小到大排（start相同end小的排前面）
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                result++;
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return result;
    }
}
