package java03;


public class ValueTransferTest {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        ValueTransferTest vt = new ValueTransferTest();

        // 官方实现：
        // 先创建关于Data的类的实例：
        Data data = new Data();
        data.m = 10;
        data.n = 20;

        vt.swap(data);
        System.out.println("m " + data.m + "n " + data.n); 


        // The method println(boolean) in the type PrintStream  
        // is not applicable for the arguments (void)
        // 函数无返回值，不能直接打印
        // vt.swap(m,n);

        // // 进行如下更改：
        // int[] array = {m, n};
        // array = vt.swap(array);
        // m = array[0]; // 20
        // n = array[1]; // 10

        // System.out.println("m " + m + "n " + n); 
        
    }
    // 以下三个函数为重载函数：
    public void swap(int m,int n){
        int temp = m;
        m = n;
        n = temp;
    }

    // 进行如下更改：
    public int[] swap(int[] array){
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
        return array;
    }   

    // 官方进行如下修改：
    public void swap(Data a){
        int temp = a.m;
        a.m = a.n;
        a.n = temp;
    }
}   
  // 官方进行如下更改：
class Data{
        int m,n;
    }
