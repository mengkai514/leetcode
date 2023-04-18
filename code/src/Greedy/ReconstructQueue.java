package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        //按照k插入
        /**
         * 插入[7,0]：[[7,0]]
         * 插入[7,1]：[[7,0],[7,1]]
         * 插入[6,1]：[[7,0],[6,1],[7,1]]
         * 插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
         * 插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
         * 插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
         */
        for (int[] p : people) {
            que.add(p[1],p);
        }
        return que.toArray(new int[people.length][]);
    }
}
