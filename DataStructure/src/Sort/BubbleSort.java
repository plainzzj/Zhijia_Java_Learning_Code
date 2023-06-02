package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};

        // 测试冒泡排序
//        bubbleSort(arr);

        // 测试冒泡排序的时间复杂度 -> 80000
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 100000000); // 0 - 亿
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前：" + data1Str);

        bubbleSort(arr);

        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后：" + data2Str);

        /*
        排序前：2023-04-18 10:49:16
        排序后：2023-04-18 10:49:24

        共耗时 8s 左右
         */



        /*
        1趟排序后的数组
        [3, -1, 9, -2, 10]
        2趟排序后的数组
        [-1, 3, -2, 9, 10]
        3趟排序后的数组
        [-1, -2, 3, 9, 10]
        4趟排序后的数组
        [-2, -1, 3, 9, 10]
         */
//        // 第二趟排序
//        for (int j = 0; j < arr.length - 2; j++) {
//            if(arr[j] > arr[j+1]){
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        /*
//        [-1, 3, -2, 9, 10]
//         */
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        // 标识，标识是否进行过交换
        boolean flag = false;
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // 双层嵌套循环，O(n^2)
                if(arr[j] > arr[j+1]){
                    flag = true; // 进行过交换！ ture！
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println((i+1) + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if(flag == false){
                // 当一趟排序中一次交换都没有发生过
                break;
            }else{
                flag = false; // 重置
            }

        }
    }
}
