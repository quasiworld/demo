package org.ck.Algorithm;

/**
 * @className: Sort
 * @description:
 * @createDate: 2022年06月17日 01:47:45
 * @author: ck
 */
public class Sort {

    public static void main(String[] args) {

       /* int[] arr = {9, 3, 4, 65, 56, 23, 1, 34};
        System.out.println(arr.length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
              //  System.out.println(arr[i] + "," + arr[j]);
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + ",");
        }*/
        jc(10);
    }

    //阶乘是什么？
    //n!
    //1
    //1*2
    //1*2*3
    //1*2*3*4
    //外层控制循环次数，内层控制具体数据
    public static void jc(int n) {
        for (int i = 1; i <= n; i++) {
            int result = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*");
                result *= j;
            }
            System.out.println("第" + i + "次" + result);
        }
    }

}
