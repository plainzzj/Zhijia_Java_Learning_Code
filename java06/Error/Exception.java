package java06.Error;

import org.junit.Test;

public class Exception {
    @Test
    public void test1(){

        int[] arr = null;
        // java.lang.NullPointerException: 
        // Cannot load from int array because "arr" is null
        System.out.println(arr[3]);
    }
}
