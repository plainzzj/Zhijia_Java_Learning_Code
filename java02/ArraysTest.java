package java02;
// 操作数组的工具类

import org.junit.Test;

import java.util.Arrays;
public class ArraysTest {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 2, 3, 4};
        int[] arr3 = new int[]{1, 3, 2, 4};

        // 判断两个数组是否相等
        boolean isEq1 = Arrays.equals(arr1, arr2);
        boolean isEq2 = Arrays.equals(arr1, arr3);
        System.out.println(isEq1);
        System.out.println(isEq2);

        // 输出数组信息
        System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4]

        // 将指定的值填充到数组中
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1)); // [10, 10, 10, 10]

        // 将数组进行排序(改变原来的数组)
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        // 寻找数组内元素
        int index = Arrays.binarySearch(arr3, 3);
        System.out.println(index);

    }

    // NC22 -> 测试
    public static int[] merge(int A[], int m, int B[], int n) {
        // 遍历数组B，将其插入数组A中
        for (int i = 0; i < n; i++) { // 注意！ fill 是将所有的字符全部变换为对应的字符！ fill(使用带int fromIndex, int toIndex的重构方法即可)
            Arrays.fill(A, B[i]);
        }
        Arrays.sort(A);
        System.out.println(A);
        return A;
    }

    @Test
    public void test() {
        int[] A = ArraysTest.merge(new int[]{1}, 1, new int[]{2}, 1); // 注意这种数组的声明+使用方式！
        for (int i : A) {
            System.out.print(i + '\t');
        }
    }
}

