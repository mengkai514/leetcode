package String;

/**
 * 151. 反转字符串中的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] initialArr = s.toCharArray();
        char[] newArr = new char[initialArr.length + 1];
        int i = initialArr.length - 1;
        int newPos = 0;
        while (i >= 0) {
            while (i >= 0 && initialArr[i] == ' ') i--;
            int right = i;
            while (i >= 0 && initialArr[i] != ' ') i--;
            for (int j = i + 1; j <= right; j++) {
                newArr[newPos++] = initialArr[j];
                if (j == right) {
                    newArr[newPos++] = ' ';
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if(newPos == 0){
            return "";
        }else{
            return new String(newArr,0,newPos-1);
        }
    }
}
