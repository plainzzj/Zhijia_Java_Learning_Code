package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;


// 缩小增量排序！
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr0 = {8,9,1,7,2,3,5,4,6,0};
//
//        Sort.ShellSort.shellsort2(arr0);
        /*
        [3, 5, 1, 6, 0, 8, 9, 4, 7, 2]
        [0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
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

        ShellSort.shellsort2(arr);

        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后：" + data2Str);

        /*
        交换法：
        排序前：2023-04-18 15:37:59
        排序后：2023-04-18 15:38:05

        共耗时 6s 左右

        移位法：
        排序前：2023-04-18 15:56:44
        排序后：2023-04-18 15:56:44

        共耗时不到1s
         */
    }

    // 使用逐步推导的方式来编写希尔排序
    // 交换法： 速度较慢
    // -> 实现方法：冒泡（交换），只是冒泡（交换）间隔不为1，所以不如insert方法
    public static void shellsort(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2; gap > 0 ; gap/=2) { // gap = 5 2 1 -> 应该遍历3次
            for (int i = gap; i < arr.length; i++) { // 10个元素 -> 5组 i: 5, 6, 7, 8, 9
                // 遍历各组中所有的元素(共5组，每组有两个元素)， 步长为5
                for (int j = i - gap; j >= 0 ; j -= gap) { //  j: 0, 1, 2, 3, 4
                    // 如果当前元素> +步长 后的元素，需要交换
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap]; // 交换！
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
    }
    // 使用逐步推导的方式来编写希尔排序
    // 移位法： 速度较快 -> 插入排序的优化！
    public static void shellsort2 (int[] arr){
        for (int gap = arr.length/2; gap > 0 ; gap/=2) { // gap = 5 2 1 -> 应该遍历3次 (间隔大小)
            for (int i = gap; i < arr.length; i++) {  // 对每个子集进行排序 i = 5,6,7,8,9
                // 第二轮：i = 2,3,4,5,6,7,8,9
                    int j = i;
                    int temp = arr[j];
                    if(arr[j] < arr[j - gap]){
                        while(j - gap >= 0 && temp < arr[j -gap]){ // i = 5,6,7,8,9 < i = 0,1,2,3,4 (共五组)
                            // 第二轮：2,3,4,5,6,7,8,9 < 0,1,2,3,4,5,6,7
                            // 移动
                            arr[j] = arr[j - gap]; // 假如 arr[5] < arr[0] -> arr[5] = arr[0]
                            j -= gap;
                    }
                        arr[j] = temp; // arr[0] = arr[5]
                }
            }
//            System.out.println(Arrays.toString(arr));
        }

    }
}
