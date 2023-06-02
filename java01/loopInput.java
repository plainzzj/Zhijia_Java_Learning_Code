package java01;
import java.util.Scanner;

// ————————————————————————————————————————————————————————————————————————————————0404
class loopInput {
    public static void main(String[] args){ // 计算键盘输入字符的正数和复数的个数
        Scanner scan = new Scanner(System.in);
        // while(scan == true)
        // Incompatible operand types Scanner and booleanJava(16777231)
        // 不兼容的操作数类型Scanner和boolean
        int positiveNum = 0;
        int negativeNum = 0;
        // Always true, or use for(;;)
        while(true){
            int num = scan.nextInt();

            if(num > 0){
                positiveNum++;
            }else if(num < 0){
                negativeNum++;
            
            }else{
            // Use break to stop the program -> 使用0来终止程序！
            break;
            }
        }
        System.out.println("positive nums: " + positiveNum);
        System.out.println("negative nums: " + negativeNum);


    }
}