package Algorithm.Test.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wangfei
 * @date: 2019/5/15 10:35
 */
public class Demo02 {

    public static void main(String[] args) {
        //字符串：asdas1213asdsancskw234234中,是否符合指定的正则表达式：\w+
        //表达式创建
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
        //创建Matcher对象
        Matcher m = p.matcher("asdas1213**asdsanc32423*skw234234");

        while (m.find()) {
            //group(),group(0)都是匹配整个表达式的字符串
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

    }
}
