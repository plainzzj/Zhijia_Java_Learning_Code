package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        // 数组
        int[] arr = new int[]{7,6,5,100,4,3,2,10};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
//        /*
//        [-9, -567, 0, 23, 78, 70]
//        [-567, -9, 0, 23, 78, 70]
//        [-567, -9, 0, 23, 70, 78]
//         */
        // 测试冒泡排序的时间复杂度 -> 80000000
//        int[] arr = new int[80000000];
//        for (int i = 0; i < 80000000; i++) {
//            arr[i] = (int)(Math.random() * 100000000); // 0 - 亿
//        }

//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String data1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前：" + data1Str);
//
//        quickSort(arr, 0, arr.length-1);
//
//        Date date2 = new Date();
//        String data2Str = simpleDateFormat.format(date2);
//        System.out.println("排序后：" + data2Str);

        /*
        8000W的数据…… 整整1000倍……
        排序前：2023-04-19 15:55:52
        排序后：2023-04-19 15:56:02
        共耗时 10s 左右
         */
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left; // 左下标
        int r = right; // 右下标
        int pivot = arr[(left + right)/2]; // 中间值(0)
        int temp = 0; // 临时变量，用于交换
        // while循环：让比pivot值小的放在左边，比pivot大的放在右边
        while(l < r){ // 当左下标小于右下标时
            // 在pivot左边一直寻找 -> 找到大于等于pivot的值，退出
            while (arr[l] < pivot){
                l += 1;
            }
            // 在pivot右边一直寻找 -> 找到小于等于pivot的值，退出
            while (arr[r] > pivot){
                r -= 1;
            }
            // l >= r 说明pivot的左右两边的值 -> 左边小，右边大
            if( l >= r){
                break;
            }
            // 否则的话进行交换：
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后，发现arr[l] == pivot值， r前移
            if (arr[l] == pivot){
                r -= 1; // 大错特错！
            }
            // 如果交换完后，发现arr[r] == pivot值， l后移
            if (arr[r] == pivot){
                l += 1;
            }
        }
        // 递归前的判断
        // 如果l == r， 必须l++, r-- -> 否则栈溢出
        if (l== r){
            l += 1;
            r -= 1;
        }

//        // 向左递归
        if(left < r){
            quickSort(arr, left, r); // 右边界是r
        }
        if(right > l){
            quickSort(arr, l, right); // 左边界是l
        }
    }
}
