package Algorithm.Test.Regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wangfei
 * @date: 2019/5/15 10:35
 */
public class Demo04 {

    public static void main(String[] args) {
        String str = "asdas1213asdsanc3242skw234234";
        String[] arr = str.split("\\d+");
        System.out.println(Arrays.toString(arr));
    }
}
