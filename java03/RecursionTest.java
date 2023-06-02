package java03;

// 递归实现求和
public class RecursionTest {
    public static void main(String[] args) {
        RecursionTest rt = new RecursionTest();
        System.out.println(rt.getSum(100));
        
    }
    // int sum = 0;
    // public int getSum(int i){
        // 递归结束条件： i < 1
    //     if(i >= 1){
    //         sum += i;
    //         i--;
    //         getSum(i);
    //     }
    //     return sum;
    // }

    // 官方实现：
    public int getSum(int n){
        // 递归结束条件： i = 1
        if(n == 1){
            return 1;
        }else{
            return n + getSum(n - 1);
        }
    }


    
}
