package Algorithm.Test.T6;

import java.util.Scanner;

/**
 * 删除重复字符
 *
 * @author: wangfei
 * @date: 2019/4/16 14:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String str = "";
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (res[s.charAt(i) - 'a'] == 0) {
                str += s.charAt(i);
            }
            res[s.charAt(i) - 'a']++;
        }
        System.out.println(str);
    }
}
