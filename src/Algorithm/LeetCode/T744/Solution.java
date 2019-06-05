package Algorithm.LeetCode.T744;

/**
 * 找到大于给定元素的最小元素
 * <p>
 * 给定只包含小写字母的已排序字符列表和给定的目标字母目标，找到列表中比给定目标大的最小元素。
 * 字母也是环绕的。例如，如果目标是target = 'z'和字母= ['a'， 'b']，那么答案是'a'。
 *
 * @author: wangfei
 * @date: 2019/4/28 11:16
 */
public class Solution {

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (target >= letters[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';
        System.out.println(nextGreatestLetter(letters, target));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }

}
