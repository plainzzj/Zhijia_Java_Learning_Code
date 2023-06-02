package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertionSort {
    public static void main(String[] args) {
//        int []arr = {101, 34, 119, 1};
//        System.out.println(Arrays.toString(arr));
//        Sort.InsertionSort.insertSort(arr);
//        System.out.println(Arrays.toString(arr));
        /*
        [101, 34, 119, 1]
        [1, 34, 101, 119]
         */
        // 测试冒泡排序的时间复杂度 -> 80000
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 100000000); // 0 - 亿
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前：" + data1Str);

        InsertionSort.insertSort(arr);

        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后：" + data2Str);

        /*
        排序前：2023-04-18 14:21:51
        排序后：2023-04-18 14:21:52

        共耗时 1s 左右
         */

    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) { // 从第二个数开始
            int insertVal = arr[i];// 定义待插入数
            int insertIndex = i - 1; // 待插入数arr[i]前面数的下标
            // 给insertVal 找到插入的位置：
        /*
        insertIndex >= 0 -> 保证在给insertVal找插入位置，不越界
        insertVal < arr[insertIndex] -> 待插入的数还未找到要插入的位置 -> 从后往前插入，越比越小
        将arr[insertIndex] 后移
         */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex]; // 后移
                insertIndex--;
            }
            // 当退出while循环时，插入位置找到：insertIndex + 1
            arr[insertIndex + 1] = insertVal;
        }


    }
}
