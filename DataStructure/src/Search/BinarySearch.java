package Search;

import java.util.ArrayList;
import java.util.List;

// 二分查找的数组必须是有序的！
public class BinarySearch {
    public static void main(String[] args) {
//        int arr[] = {1, 8, 10, 89, 1000, 1234};
//        int resIndex = binarySearch(arr, 0, arr.length-1, 89);
//        System.out.println(resIndex);
        /*
        3
         */
        int arr[] = {1, 8, 10, 89, 1000,1000,1000,1000,1000, 1234};
        List<Integer> resIndex = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(resIndex);

    }
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        if(left > right){
            return -1; // 找不到~！
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal){
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if(left > right){
            return new ArrayList<>(); // 找不到~！
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal){
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            /*
            找到mid索引值：不要马上返回
            1. 向mid索引值的左边扫描： 将所有满足元素的下标，加入集合ArrayList
            2. 向mid索引值的右边扫描： 将所有满足元素的下标，加入集合ArrayList
             */
            List<Integer> resIndexList = new ArrayList<>();
            resIndexList.add(mid);
            int temp = mid - 1;
            while (true){
                if(temp < 0 || arr[temp] != findVal){
                    break;
                }else{
                    resIndexList.add(temp);
                    temp -= -1;
                }

            }
            temp = mid + 1;
            while (true){
                if(temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }else{
                    resIndexList.add(temp);
                    temp += 1;
                }

            }
            return resIndexList;
        }

    }
}
