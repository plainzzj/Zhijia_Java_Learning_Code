package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RadixSort {
    public static void main(String[] args) {
//        int arr[] = {53, 3, 542, 748, 14, 214};
//        System.out.println(Arrays.toString(arr));
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
//        /*
//        [53, 3, 542, 748, 14, 214]
//        [542, 53, 3, 14, 214, 748]
//        ...
//        [3, 14, 53, 214, 542, 748]
//
//         */

        // 测试冒泡排序的时间复杂度 -> 80000
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int)(Math.random() * 100000000); // 0 - 亿
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前：" + data1Str);

        RadixSort.radixSort(arr);

        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后：" + data2Str);

        /*
        八千万数据~
        排序前：2023-04-20 16:32:56
        排序后：2023-04-20 16:33:02

        共耗时 6s 左右 -> 特别耗费内存
        80000000 * 11 * 4/1024/1024/1024G -> 3.2GB左右
         */
    }

    // 基数排序方法
    public static void radixSort(int[] arr) {
        // 1. 得到数组中最大数的位数：
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 2. 得到最大数是几位数？
        int maxLenth = (max + "").length();
        // 3. 使用循环
        for (int i = 0, n = 1; i < maxLenth; i++, n *= 10) {
            // 第一轮排序：针对每个元素个位的排序
            // 定义一个二维数组表示桶 -> 每个桶是一个一维数组
            //
            int[][] bucket = new int[10][arr.length]; // -> 防止数据溢出，空间换时间
            // 定义一个一维数组来记录每次放入的数据个数
            int[] bucketElementCounts = new int[10];

            // 取元素的个位
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] /n % 10;
                // 放入对应的桶
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 按照桶的顺序，放入原来数组
            int index = 0;
            // 遍历每一个桶，并将桶中的数据放入原数组：
            for (int k = 0; k < bucketElementCounts.length; k++) { // 遍历10个桶
                // 如果桶中有数据，放入原数组，
                if (bucketElementCounts[k] != 0) {
                    // 循环改第k个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素，放入原数组
                        arr[index] = bucket[k][l]; // k桶中的第l个元素！
                        index++;
                    }
                    // 重置为0 -> 需要将每个bucketElementCounts重置为0
                    bucketElementCounts[k] = 0;

                }

            }

        }
    }
}
