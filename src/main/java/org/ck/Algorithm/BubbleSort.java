package org.ck.Algorithm;

import java.util.Arrays;

/**
 * @className: BubbleSort
 * @description: 冒泡排序
 * @createDate: 2021年02月23日 17:56:46
 * @author: ck
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{3, 8, 5, 6, 7, 9, 1, 4, 2, 9};
        sort(arrs);
        for (int arr : arrs) {
            System.out.print(arr);
        }
    }
    private static void sort2(int[] arrs) {
        int count = 0 ;
        for (int i = 0; i < arrs.length ; i++) {
            for (int j = 0; j < arrs.length; j++) {
                if (arrs[i] < arrs[j]) {
                    int temp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = temp;
                    System.out.println(Arrays.toString(arrs));
                }
                count++;
            }
            System.out.println("第" + i + "次循环" + Arrays.toString(arrs));
        }
        System.out.println(count);
    }

    private static void sort(int[] arrs) {
        int count = 0 ;
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] < arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                    System.out.println(Arrays.toString(arrs));
                }
                count++;
            }
            System.out.println("第" + i + "次循环" + Arrays.toString(arrs));
        }
        System.out.println(count);
    }


}