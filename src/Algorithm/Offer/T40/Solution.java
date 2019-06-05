package Algorithm.Offer.T40;

/**
 * 数组中只出现一次的数字
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author: wangfei
 * @date: 2019/5/8 22:08
 */
public class Solution {

    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * <p>
     * 位运算
     *
     * @param array
     * @param num1
     * @param num2
     */
    public static int FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int diff = 0;
        for (int arr : array) {
            diff ^= arr;
        }
        diff &= -diff;
        for (int arr : array) {
            if ((arr & diff) == 0) {
                num1[0] ^= arr;
            } else {
                num2[0] ^= arr;
            }
        }
        return num1[0];
    }

    /**
     * HashMap 统计数组中数字出现的次数
     * 遍历数组，如果出现次数为奇数，则保存
     *
     * @param array
     * @param num1
     * @param num2
     */
//    public static void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            if (map.containsKey(array[i]))
//                map.put(array[i], ++(map.get(array[i])));
//            else
//                map.put(array[i], 1);
//        }
//        boolean flag = false;
//        for (int i = 0; i < array.length; i++) {
//            if (map.get(array[i]) % 2 == 1) {
//                if (!flag) {
//                    num1[0] = array[i];
//                    flag = true;
//                } else
//                    num2[0] = array[i];
//            }
//        }
//    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int num1[] = new int[1];
        int num2[] = new int[1];
        System.out.println(FindNumsAppearOnce(array, num1, num2));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
