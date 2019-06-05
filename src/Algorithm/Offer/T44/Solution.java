package Algorithm.Offer.T44;

/**
 * 翻转单词顺序列
 *
 * @author: wangfei
 * @date: 2019/5/9 21:40
 */
public class Solution {

    /**
     * 1、不使用额外的空间
     * 2、先反转每个单词，使用 start 和 end 来标记每个单词，end 走到空格时，反转 start - end-1；end 走到最后时，反转 start - end
     * 3、再反转整个字符串
     *
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int start = i, end = i;
            while (chars[end] != ' ' && end < str.length() - 1) {
                end++;
            }
            if (end == chars.length - 1) {
                reverse(chars, start, end);
                break;
            } else {
                reverse(chars, start, end - 1);
                i = end;
            }
        }
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "Hello World!";
        System.out.println(ReverseSentence(str));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
