package String;

/**
 * 344. 反转字符串
 */
public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        reverseString(s.toCharArray());
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
