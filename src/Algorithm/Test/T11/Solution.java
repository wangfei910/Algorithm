package Algorithm.Test.T11;

/**
 * == 测试
 *
 * @author: wangfei
 * @date: 2019/6/4 21:47
 */
public class Solution {

    public static void main(String[] args) {

        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;
        String h = "a" + "b";

        // == 对比的是地址，即是不是同一对象
        System.out.println(b.intern() == a);  // false b.intern 指向常量池，a 指向堆中
        System.out.println(b.intern() == c);  // true  b.intern 指向常量池，c 指向常量池
        System.out.println(b.intern() == d);  // true  b.intern 指向常量池，d 在编译时会变成 ab 也被放入常量池
        System.out.println(b.intern() == f);  // false b.intern 指向常量池，e 是变量不会被放入常量池，所以 f 也不会放入
        System.out.println(b.intern() == a.intern()); // true a.intern 指向常量池，b.intern 指向常量池
        System.out.println(c== h);  // true  c 被放在常量池，h 被编译成 abc 也放在常量池
    }
}
