package java01;

import org.junit.Test;

// ————————————————————————————————————————————————————————————————————————————————0404
// 一些有关计算符号的用法
public class AriTest {
    public static void main(String[] args){

        int num1 = 12;
        int num2 = 5;
        int result1 = num1/num2;
        System.out.println(result1); //2

        double result2 = num1/num2;
        System.out.println(result2); //2.0

        double result3 = (double)num1/(double)num2;
        System.out.println(result3); // 2.4

        // 自增一（不回改变本身的数据类型 ）
        int a1 = 10;
        int a2 = 10;
        int b1 = a1++; // b1 == a1，and a1 + 1
        int b2 = ++a2; // a2 + 2, and b2 == a2
        System.out.println(b1);
        System.out.println(b2);
        
        // 输出个十百位
        int num = 256;
        int hundred = num / 100;
        int ten = num / 10 - hundred  *10;
        int one = num % 10;
        System.out.println(num);
        System.out.println(hundred);
        System.out.println(ten);
        System.out.println(one);

        // 连续赋值
        int z1 = 10, j3 = 10;

        // 逻辑与& 短路与&&
        // 整个表达式结果已经确定是false，所有后面的表达式没有再执行，这种现象被称为短路现象，短路与才会有短路现象。
        boolean c1 = true;
        c1 = false;
        int numc1 = 10;
        if(c1 & (numc1++ > 0)){
            System.out.println("case 1");    
        }else{
            System.out.println("case 2"); 
        }
        System.out.println(numc1);

        boolean c2 = true;
        c2 = false;
        int numc2 = 10;
        if(c2 && (numc2++ > 0)){
            System.out.println("case 1");    
        }else{
            System.out.println("case 2"); 
        }
        System.out.println(numc2);
    }

    @Test
    public void test1(){
        int a = 20;
        int b = a;
        b = 10;
        System.out.println(a); // 20 不会被b的值影响
    }
    
}
