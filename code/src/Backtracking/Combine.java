package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 */
public class Combine {
    LinkedList<Integer> paths = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    private void backtracking(int n, int k, int startIndex) {
        if (paths.size() == k) {
            result.add(new ArrayList<>(paths));
            return;
        }
        /**
         * 优化过程如下：
         * 1.已经选择的元素个数：path.size();
         * 2.还需要的元素个数为: k - path.size();
         * 3.在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
         * 为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
         * 举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
         * 从2开始搜索都是合理的，可以是组合[2, 3, 4]。
         */
        for (int i = startIndex; i <= n - (k - paths.size()) + 1; i++) {
            paths.add(i);
            backtracking(n, k, i + 1);
            paths.removeLast();
        }
    }
}
