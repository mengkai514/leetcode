package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class CombinationSum3 {
    LinkedList<Integer> paths = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum;
    public List<List<Integer>> combinationSum3(int k, int n) {
        sum = n;
        getSum3(k, n, 1);
        return result;
    }

    private void getSum3(int k, int n, int startIndex) {
        if (paths.size() != 0) sum -= paths.getLast();
        if (paths.size() == k) {
            if (sum == 0) {
                result.add(new ArrayList(paths));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            if (paths.size() != 0 && i == paths.getLast()) continue;
            paths.add(i);
            getSum3(k, n, i + 1);
            sum += paths.getLast();
            paths.removeLast();
        }
    }
}
