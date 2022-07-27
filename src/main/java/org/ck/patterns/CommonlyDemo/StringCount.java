package org.ck.patterns.CommonlyDemo;

/**
 * @ClassName: Test
 * @description
 * @Date 2020年04月27日 14:06:33
 */
public class StringCount {
    public static void main(String[] args) {
        String s = "sgjkflsdfjdsljfsdkasd";
        //统计字符串s出现的数量
        int count = 0;
        while (s.contains("s")) {
            count++;
            s = s.substring(s.indexOf("s") + 1);
        }
        System.out.println(count);
    }
}
