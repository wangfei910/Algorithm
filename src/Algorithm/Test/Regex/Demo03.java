package Algorithm.Test.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wangfei
 * @date: 2019/5/15 10:35
 */
public class Demo03 {

    public static void main(String[] args) {
        //字符串：asdas1213asdsancskw234234中,是否符合指定的正则表达式：\w+
        //表达式创建
        Pattern p = Pattern.compile("[0-9]");
        //创建Matcher对象
        Matcher m = p.matcher("asdas1213**asdsanc32423*skw234234");

        //替换
        String newStr = m.replaceAll("#");
        System.out.println(newStr);
    }
}
