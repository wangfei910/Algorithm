package Algorithm.Test.T6;

import java.util.Scanner;

/**
 * 删除重复字符
 *
 * @author: wangfei
 * @date: 2019/4/16 13:48
 */
public class Soulion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String str = "";
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 1 << (s.charAt(i) - 'a');
            // 第一次出现
            if ((temp & flag) == 0) {
                str += s.charAt(i);
                flag |= temp;
            }
        }
        System.out.println(str);
    }
}
