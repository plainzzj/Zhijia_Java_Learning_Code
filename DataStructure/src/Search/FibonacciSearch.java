package Search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println(fibSearch(arr, 1234));
    }

    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];


        }
        return f;
    }

    /**
     *
     * @param a 数组
     * @param key 需要查找的关键码
     * @return 返回对应的下标
     */
    public static int fibSearch(int[] a, int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0; // 斐波那契分割数值的下标
        int mid = 0;
        int f[] = fib();
        while (high > f[k] - 1){ // 获取到斐波那契分割数值的下标
            k++;
        }
        // 由于f[k]值可能 > a的长度，因此需要使用Arrays类，构造一个新的数组，并指向a[]
        // 不足的部分使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        // 实际上使用a数组最后的数填充：
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        // 使用while来循环处理，找到我们的数key
        while(low <= high){
            mid = low + f[k-1] -1;
            if(key < temp[mid]){ // 继续向左查找
                high = mid - 1;
                k--;
            }else if(key > temp[mid]){ // 继续向右查找
                low = mid + 1;
                k -= 2;
            }else{ // 找到
                if(mid <= high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;


    }
}
