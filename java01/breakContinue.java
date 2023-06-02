package java01;
// ————————————————————————————————————————————————————————————————————————————————0404
// The declared package "java01" does not match the expected package ""Java(536871240)
public class breakContinue {
    public static void main(String[] args){
        for(int i = 1; i <= 10; i++){
            if(i % 4 == 0){
            //break; // 123 -> 退出循环
            continue;  // 123567910 -> 继续循环
        }
        System.out.print(i);
    }
    }
}