package cn.jzh.java;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/2 11:01
 */
public class RegexTest {
    @Test
    public void test1() {
        String str = "{\"product\":\"1\",\"code\":\"5772\",\"param\":\"200\"}";
        Pattern p1 = Pattern.compile("\"(\\d*)\"");
        Matcher m = p1.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
