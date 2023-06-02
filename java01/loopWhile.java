package java01;
// ————————————————————————————————————————————————————————————————————————————————0404

class loopWhile {
    public static void main(String[] args){ // 从100输出到0（偶数）
        int num = 100;
        while(num > 0){
            System.out.println(num);
            num -= 2;
        }

    }
}