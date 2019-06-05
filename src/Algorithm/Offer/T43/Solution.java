package Algorithm.Offer.T43;

/**
 * 左旋转字符串
 *
 * @author: wangfei
 * @date: 2019/5/9 19:58
 */
public class Solution {

    /**
     * 递归
     * 1、反转 n 前半部分的字符串，反转 n 后半部分的字符串，得到新的字符串 temp
     * 2、反转 temp
     *
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0)
            return "";
        if (n == 0)
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
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
     * 模拟循环
     * 1、左移次数对数组长度取模，则是最终移动次数 index
     * 2、先添加 index 后的元素，再添加 index 前的元素
     *
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString2(String str, int n) {
        if (str == null || str.length() == 0)
            return "";
        if (n == 0)
            return str;
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "abcdefgh";
        int n = 3;
        System.out.println(LeftRotateString2(str, n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
