package String;

/**
 * 28. 找出字符串中第一个匹配项的下标
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad","tsa"));
    }
    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            int length = needle.length();
            int index = 0;
            int result = 0;
            while (index < haystack.length()) {
                char[] hay = haystack.toCharArray();
                char[] nee = needle.toCharArray();
                if (hay[index] == nee[0]) {
                    String substring = haystack.substring(index, length + index);
                    if (substring.equals(needle)) {
                        result = index;
                        break;
                    }
                }
                index++;
            }
            return result;
        } else {
            return -1;
        }
    }
}
