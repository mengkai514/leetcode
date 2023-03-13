package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("ab","b"));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int length = 0;
        while (length < t.length()) {
            char c = t.charAt(length);
            length++;
            map.put(c,map.getOrDefault(c,0)-1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
