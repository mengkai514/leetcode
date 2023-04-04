package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        getLetterCombinations(0, digits, numString);
        return result;
    }

    private void getLetterCombinations(int startIndex, String digits, String[] numString) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            getLetterCombinations(startIndex + 1, digits, numString);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
