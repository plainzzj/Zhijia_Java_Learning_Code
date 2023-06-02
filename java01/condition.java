package java01;

import java.util.Scanner;

// ————————————————————————————————————————————————————————————————————————————————0404

class condition {
    public static void main(String[] args){
        int heartBeats = 78;
        if(heartBeats < 60 || heartBeats > 100){
            System.out.println("error");
        }
        else{
            System.out.println("right");
        }

        // tips:Resource leak: 'scan' is never closed
        // Scanner -> 捕获键盘输入
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(num);

        String name = scan.next();
        System.out.println(name);
        
        // closed scan -> 关闭
        scan.close();

        

        // random num
        int value = (int)(Math.random() * 90 + 10);

    }
    
}


