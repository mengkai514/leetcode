package Backtracking;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class CombinationSum {
    LinkedList<Integer> paths = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum = target;
        getCombinationSum(candidates, target, 0);
        return result;
    }

    private void getCombinationSum(int[] candidates, int target, int startIndex) {
        if (paths.size() != 0) sum -= paths.getLast();
        if (sum == 0) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            paths.add(candidates[i]);
            getCombinationSum(candidates, target, i + 1);
            sum += paths.getLast();
            paths.removeLast();
        }
    }
}
