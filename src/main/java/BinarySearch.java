/**
 * @className: BinarySearch
 * @description: 二分查找法
 * @createDate: 2021年12月18日 23:58:18
 * @author: ck
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(array, 7));
    }

    public static int search(int[] array, int des) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (des > array[mid]) {
                start = mid + 1;
            } else if (des < array[mid]) {
                end = mid - 1;
            } else {
                return array[mid];
            }
        }
        return -1;
    }
}
