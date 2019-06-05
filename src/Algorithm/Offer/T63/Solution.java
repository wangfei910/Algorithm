package Algorithm.Offer.T63;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * @author: wangfei
 * @date: 2019/5/16 10:22
 */
public class Solution {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private int count = 0;

    /**
     * 1、小顶堆存储右边元素，大顶堆存储左边元素，并且大顶堆的堆顶小于小顶堆的堆顶
     * 2、分为奇数和偶数
     * 3、偶数：新加入的元素进入大顶堆，筛选出最大的元素进入小顶堆，返回 minHeap.peek() + maxHeap.peek() / 2
     * 4、奇数：新加入的元素进入小顶堆，筛选出最小的元素进入大顶堆，返回 minHeap.peek()
     *
     * @param num
     */
    public void Insert(Integer num) {
        if (count % 2 != 0) {
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }
        ++count;
    }

    public Double GetMedian() {
        if (count % 2 != 0) {
            return (double) minHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    private LinkedList<Integer> list = new LinkedList<>();

    public void Insert1(Integer num) {
        if (list.size() == 0 || num < list.getFirst()) {
            list.addFirst(num);
        } else {
            boolean insertFirst = false;
            for (Integer e : list) {
                if (num < e) {
                    int index = list.indexOf(e);
                    list.add(index, num);
                    insertFirst = true;
                    break;
                }
            }
            if (!insertFirst) {
                list.addLast(num);
            }
        }
    }

    public Double GetMedian2() {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() % 2 == 0) {
            int i = list.size() / 2;
            return Double.valueOf(list.get(i - 1) + list.get(i)) / 2;
        }
        list.get(0);
        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));
    }
}
