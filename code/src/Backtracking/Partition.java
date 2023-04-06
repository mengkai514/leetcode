package Backtracking;

import java.util.*;

/**
 * 131. 分割回文串
 */
public class Partition {
    List<List<String>> result = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();
    public List<List<String>> partition(String s) {
        getPartition(s, 0);
        return result;
    }

    private void getPartition(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPartition(startIndex, s, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.add(str);
            } else {
                continue;
            }
            getPartition(s, i + 1);
            deque.removeLast();
        }
    }

    private boolean isPartition(int startIndex, String s, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
