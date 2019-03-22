package Algorithm.LeetCode.T703;

import java.util.PriorityQueue;

/**
 * 返回数据流中第k大元素
 *
 * @author wangfei
 */
public class KthLargest {

    final PriorityQueue<Integer> q;
    final int k;

    /**
     * 1.利用优先队列创建元素个数为k的小顶堆
     * 2.遍历数组元素添加到优先队列中，前k个元素组成小顶堆，其余元素依次与堆顶元素比较，
     * 若堆顶元素小于该元素，则替换堆顶元素并重新排列为小顶堆直至遍历完所有元素
     * 3.返回的堆顶元素即为原数组中的第k大元素
     *
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int val : nums)
            add(val);
    }

    public int add(int val) {
        if (q.size() < k)
            q.offer(val);
        else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        System.out.print(new KthLargest(k, nums));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
