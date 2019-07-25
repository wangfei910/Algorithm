package Algorithm.Test.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wangfei
 * @date: 2019/5/15 10:35
 */
public class Demo05 {

    public static String getURLContent(String urlStr, String charset){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> getMatcherSubstrs(String destStr, String regexStr) {
        //取到超链接的地址
        Pattern p =  Pattern.compile(regexStr);
        Matcher m = p.matcher(destStr);
        List<String> result = new ArrayList<>();
        while (m.find()) {
            result.add(m.group(1));
        }
        return result;
    }

    public static void main(String[] args) {
        String destStr = getURLContent("http://www.163.com", "gbk");
        List<String> result = getMatcherSubstrs(destStr, "href=\"([\\w\\s./:]+?)\"");
        for (String temp : result) {
            System.out.println(temp);
        }
    }
}
