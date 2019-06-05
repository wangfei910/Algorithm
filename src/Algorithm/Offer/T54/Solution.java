package Algorithm.Offer.T54;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 字符流中第一个不重复的字符
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * @author: wangfei
 * @date: 2019/5/12 21:14
 */
public class Solution {

    private Queue<Character> queue = new LinkedList<>();
    int[] arr = new int[256];
    /**
     * 从stringstream插入一个字符
     * <p>
     * 1、int[256] 标记字符出现的次数
     * 2、Queue 将输入流的字符入队
     * 3、当队头元素出现重复时，一直出队，直到队头元素不重复
     * 4、队列为空，无不重复字符；队列不为空，输出队头
     *
     * @param ch
     */
    public void Insert(char ch) {
        ++arr[ch];
        queue.add(ch);
        while (!queue.isEmpty() && arr[queue.peek()] > 1) {
            queue.remove();
        }
    }

    /**
     * 返回当前字符串流中的第一个appearence
     *
     * @return
     */
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
