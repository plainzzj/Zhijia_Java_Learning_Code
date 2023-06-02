package Search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        for(int i = 0; i < 10000; i++){
            arr[i] = i + 1;
        }
//        System.out.println(arr);

        int res = insertValueSearch(arr, 0, 9999, 4567);
        System.out.println(res);

    }
    public static int insertValueSearch(int[] arr, int left, int right, int findVal){
        if(left > right || findVal < arr[0] || findVal > arr[arr.length-1]){
            return -1;
        }

        // 求出mid
        int mid = left + (right - left) * (findVal - arr[left])/(arr[right] - arr[left]);
        System.out.println(mid);
        int midval = arr[mid];

        if(findVal > midval){ // 向右查找
            return insertValueSearch(arr, mid+1, right, findVal);
        }else if(findVal < midval){ // 向左查找
            return insertValueSearch(arr, right, mid-1, findVal);
        }else{
            return mid;
        }
    }
}
