package Algorithm.Test.T5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 蜜蜂采蜜
 *
 * @author: wangfei
 * @date: 2019/4/5 17:25
 */
public class Solution {

    static double[][] arr = new double[6][2];
    static double[][] dis = new double[6][6];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double distance = 0;
        //输入蜂巢坐标
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        //计算蜂巢之间的距离
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dis[i][j] = Math.sqrt((arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0]) + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]));
            }
        }
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(4);
        alist.add(5);
        distance = showin(0, alist);
        System.out.println((int) distance);
    }

    private static double showin(int b, ArrayList<Integer> alist) {
        Iterator<Integer> it = alist.iterator();
        double max = 80000000;
        if (!it.hasNext())
            return 0;
        if (alist.size() == 1) {
            Integer i = it.next();
            return dis[0][i] + dis[b][i];
        }
        while (it.hasNext()) {
            Integer a = it.next();
            ArrayList<Integer> alist1 = new ArrayList<>();
            alist1.addAll(alist);
            alist1.remove(a);
            Double c = showin(a, alist1);
            if (max > dis[b][a] + c)
                max = dis[b][a] + c;
        }
        return max;
    }
}
