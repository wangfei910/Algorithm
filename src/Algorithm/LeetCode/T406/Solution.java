package Algorithm.LeetCode.T406;

import Algorithm.common.Node;

import java.util.*;

/**
 * 根据身高和序号重组队列
 *
 * @author: wangfei
 * @date: 2019/4/17 19:26
 */
public class Solution {

    /**
     * 题目描述：一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
     * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的
     * 第 k 个位置可能会变成第 k+1 个位置。身高降序、k 值升序，然后按排好序的顺序插入队列的第 k 个位置中。
     *
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        //将数组队列按顺序排列为[[7, 0], [7, 1], [6, 1], [5, 0], [5, 1], [4, 4]]
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
//        System.out.println(Arrays.deepToString(people));
        List<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }


    public static int[][] reconstructQueue1(int[][] people) {
        if (people.length == 0) return new int[0][2];
        Arrays.sort(people, new Comparator<int[]>() {

            /**
             * 此处与c++的比较函数构成不一致
             * c++ 返回 bool 型,而 Java 返回的为 int 型
             * 当返回值 >0 时进行交换，即排序(源码实现为两枢轴快速排序)
             */
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        Node res = new Node(people[0]);
        for (int i = 1; i < people.length; i++) {
            res = Node.insert(res, people[i]);
        }
        int[][] resAr = new int[people.length][2];
        for (int i = 0; i < people.length; i++, res = res.next) {
            resAr[i] = res.person;
        }
        return resAr;
    }


    /**
     * 主函数
     * Arrays.deepToString()主要用于数组中还有数组的情况，而Arrays.toString()则相反，
     * 对于Arrays.toString()而言，当数组中有数组时，不会打印出数组中的内容，只会以地址的形式打印出来。
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 1}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
