package Algorithm.LeetCode.T278;

/**
 * 第一个错误的版本
 *
 * @author: wangfei
 * @date: 2019/4/28 20:10
 */
public class Solution extends VersionControl{

    public static int firstBadVersion(int n) {
        int l = 0, h = n;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 5;
        System.out.println(firstBadVersion(n));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }

}
