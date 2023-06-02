package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
//        int arr[] = {8,4,5,7,1,3,6,2};
//
//        mergeSort(arr, 0, arr.length - 1, new int[arr.length]); // 归并排序需要一个额外的空间
//
//        // 归并排序后
//        System.out.println(Arrays.toString(arr));
//        /*
//        [1, 2, 3, 4, 5, 6, 7, 8]
//         */
        // 测试冒泡排序的时间复杂度 -> 80000000
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int)(Math.random() * 100000000); // 0 - 亿
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前：" + data1Str);
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
//        quickSort(arr, 0, arr.length-1);

        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后：" + data2Str);

        /*
        8000W的数据…… 整整1000倍……
        排序前：2023-04-19 15:55:05
        排序后：2023-04-19 15:55:15
        共耗时 10s 左右
         */
    }
    // 分解 + 合并的方法
    public static void mergeSort(int[] arr, int left, int right, int[]temp){
        if(left < right){
            int mid = (left + right) / 2; // 中间索引
            // 向左递归进行分解：
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解：
            mergeSort(arr, mid + 1, right, temp);
            // 每分解一次就合并一次！
            merge(arr, left, mid, right, temp);
        }
    }
    // 合并的方法
    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 用于做中转的数组
     */
    public static void merge(int[] arr, int left,  int mid, int right, int[]temp){
        int i = left; // 初始化i，左边有序序列的初始索引
        int j = mid + 1; // 初始化i，右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        // 1. 先把左右（有序）的数据按照规则填充到temp数组 -> 左右两边的有序序列有一边处理完毕为止
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1; // temp数组后移
                i += 1; // 左边有序数组后移
            }else{
                temp[t] = arr[j];
                t += 1; // temp数组后移
                j += 1; // 左边有序数组后移
            }
        }
        // 2. 剩余数据依次全部填充入temp
        while (i <= mid){ // 左边序列还有剩余
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){ // 左边序列还有剩余
            temp[t] = arr[j];
            t++;
            j++;
        }
        // 3. 将temp拷贝到arr
        // 并不是每次都拷贝所有数据！
        /*
        第一次： tempLeft = 0, right = 1
        第二次： tempLeft = 2, right = 3
        第三次： tempLeft = 0, right = 3
        ...
        最后一次（第七次）： tempLeft = 0, right = 7
         */
        t = 0;
        int tempLeft = left; // 始终都从左边拷
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }


    }
}
