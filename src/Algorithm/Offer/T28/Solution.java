package Algorithm.Offer.T28;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 *
 * @author: wangfei
 * @date: 2019/5/4 23:33
 */
public class Solution {

    /**
     * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
     * <p>
     * 使用 count 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 count++，否则令 count--。如果前面查找了 i 个元素，
     * 且 count == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话
     * count 就一定不会为 0 。此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
     *
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        int majority = array[0];
        //确定出现次数超过一半的数字
        for (int i = 1, count = 1; i < array.length; i++) {
            count = array[i] == majority ? count + 1 : count - 1;
            if (count == 0) {
                majority = array[i];
                count = 1;
            }
        }
        int count = 0;
        for (int arr : array) {
            if (arr == majority) {
                count++;
            }
        }
        return count > array.length / 2 ? majority : 0;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
