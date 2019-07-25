package Algorithm.Test.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wangfei
 * @date: 2019/5/15 10:35
 */
public class Demo01 {

    public static void main(String[] args) {
        //字符串：asdas1213asdsancskw234234中,是否符合指定的正则表达式：\w+
        //表达式创建
        Pattern p = Pattern.compile("\\w+");
        //创建Matcher对象
        Matcher m = p.matcher("asdas1213asdsancskw234234");
        //尝试将整个字符序列与该模式匹配
        boolean yesorno = m.matches();
        System.out.println(yesorno);
    }
}
