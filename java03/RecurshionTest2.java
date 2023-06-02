package java03;

public class RecurshionTest2 {
    public static void main(String[] args) {
        // int func0 = 1, func1 = 4;
        RecurshionTest2 rt = new RecurshionTest2();
        System.out.println(rt.func(10)); // 10497
    }
    public int func(int i){
            if(i == 0){
                return 1;
            }else if(i == 1){
                return 4;
            }else{
                return (2*func(i - 1) + func(i -2));
            }
    
        }
       
    }
    