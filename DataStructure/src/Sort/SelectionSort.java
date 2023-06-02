package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectionSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
//        Sort.SelectionSort.selectSort(arr);
        /*
        [1, 34, 119, 101]
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

        SelectionSort.selectSort(arr);

        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后：" + data2Str);

        /*
        排序前：2023-04-18 13:11:05
        排序后：2023-04-18 13:11:07

        共耗时 2s 左右
         */

    }

    // 选择排序 -> O(n^2)
    public static void selectSort(int[] arr){


        for (int i = 0; i < arr.length -1; i++) {
            int minIndex = i; // 最小值的索引
            int min = arr[i]; // 最小值本身
            for (int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]){ // 寻找最小值
                    min = arr[j]; // 重置最小值
                    minIndex = j; // 重置最小值的索引
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i]; // 在原本存放最小值的位置（arr[j]），存放现在的arr[0]
                arr[i] = min;
            }
//            System.out.println((i+1) + "轮后：");
//            System.out.println(Arrays.toString(arr));
        }
        // 将最小值放置到[0]索引的位置
    }
}
