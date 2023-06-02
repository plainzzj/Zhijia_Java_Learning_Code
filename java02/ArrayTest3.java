package java02;

public class ArrayTest3 {
    public static void main(String[] args) {
    
    double[][] arr = new double[4][];
    // arr[1]一维数组 -> 引用类型，默认值为null
    System.out.println(arr[1]); // null

    String[] arr1 = new String[]{"UU","SS","TT","CC"};
    // 数组的复制（区别于数组变量的赋值，arr2 = arr1）
    String[] arr2 = new String[arr1.length];
    for(int i = 0; i <arr1.length; i++){
        arr2[i] = arr1[i];
    }

    // 数组的反转 方法1
    for(int i = 0; i < arr2.length/2; i++){
        String temp = arr2[i];
        arr2[i] = arr2[arr2.length - i - 1];
        // Type mismatch: cannot convert from String to double[]
        // arr2 误写为 arr (doble[][])
        arr2[arr2.length - i - 1] = temp;
    }
    for(int i = 0; i < arr2.length; i++){
        System.out.print(arr2[i] + "\t");
    }
    // 数组的反转 方法2
    for(int i = 0, j = arr2.length - 1; i < j; i++,j--){
        String temp = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = temp;
    }
    for(int i = 0; i < arr2.length; i++){
        System.out.print(arr2[i] + "\t");
    }

    // 数组的查找（线性查找）
    String dest = "TT";
    boolean isFlag = true;
    for(int i = 0; i < arr2.length; i++){
        if(dest.equals(arr2[i])){
            System.out.println("find: "+ i);
            isFlag = false;
            break;
        } 
    }
    if(isFlag) System.out.println("Sorry, cannot find");

    // 二分法查找： 数据必须有序！
    int[] arr4 = new int[]{-77, -45, -22, 0, 1, 3, 6, 8, 12, 44, 66};
    int dest1 = 66, head = 0, end = arr4.length - 1;// 需要查找的数字/首索引/尾索引
    boolean isFlag1 = true;
    while(head <= end){
        int middle = (head + end)/2;
        if(dest1 == arr4[middle]){
            System.out.println("find the num: " + middle);
            isFlag1 = false;
            break;
        }
        else if(dest1 < arr4[middle]){
            end = middle - 1;
        }
        else if(dest1 > arr4[middle]){
            head = middle + 1;
        }
        if(isFlag1){
            System.out.println("Cannot find");
        }
    }
    }
} 
