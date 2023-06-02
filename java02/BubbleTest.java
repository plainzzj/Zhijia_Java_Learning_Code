package java02;

public class BubbleTest {
    public static void main(String[] args) {
        int[] arr = new int[]{23,45,67,54,89,-43,-23,0,67,-99,1}; // 11
        // 冒泡排序
        // 8个元素，7轮冒泡
        for(int i = 0; i < arr.length -1; i++){
            // Index 11 out of bounds for length 11
            // 长度为11，索引只能到10
            for(int j = 0; j < (arr.length - i - 1); j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 1; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
        
    }
    
}
