package Algorithm.Offer.T2;

/**
 * 替换空格
 *
 * @author wangfei
 */
public class Solution {
    public static String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else
                newStr.append(str.charAt(i));
        }
        return newStr.toString();
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
