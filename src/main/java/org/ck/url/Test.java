package org.ck.url;

/**
 * @ClassName: Test
 * @description 阶乘
 * @Date 2020年06月06日 12:54:39
 */
public class Test {
    public static void main(String[] args) {
        //N!
        int n = 9;
        for (int i = 1; i <= n; i++) {
            int result = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                result *= j;
            }
            System.out.println("第" + i + "次" + result);
            System.out.println();
        }
    }
}
