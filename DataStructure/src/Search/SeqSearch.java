package Search;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        System.out.println(index);
        /*
        2
         */
    }

    public static int seqSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1; // 找不到返回-1
    }
}
