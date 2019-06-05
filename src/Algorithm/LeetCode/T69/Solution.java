package Algorithm.LeetCode.T69;

import static java.lang.Math.abs;

/**
 * @author: wangfei
 * @date: 2019/3/26 20:40
 */
public class Solution {

    /**
     * 二分查找（适合数组，不适合链表）
     * 1.Sorted(单调递增或者递减)
     * 2.Bounded(存在上下界)
     * 3.Accessible by index(能够通过索引访问)
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 0, right = x, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static double mySqrt1(int x) {
        if (x <= 1)
            return x;
        double left = 0, right = x, res = 0;
        while (abs(right - left) > 1e-5) {
            double mid = (left + right) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
                res = mid;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if (x <= 1)
            return x;
        int res = x;
        while (res > x / res) {
            res = res / 2 + x / res / 2;
        }
        return res;
    }

    public static int mySqrt3(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int x = 2147395600;
        System.out.println(mySqrt(x));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }

}
