package java01;


// ————————————————————————————————————————————————————————————————————————————————0404
class loopFor {
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++){
            System.out.println("Hello World" +' '+ i); // for 循环
        }
        System.out.println("_______________________________________________________________________________");
        int num = 1;
        for(System.out.println('a'); num <= 5; System.out.println('c'), num++){ // 逗号表示分别执行
            System.out.println('b');
            // abc bc bc... 主要是为了展示for中执行顺序
        }
        System.out.println("_______________________________________________________________________________");


        int sum = 0;
        for(int i = 2; i < 101; i += 2){
            System.out.println(i);
            sum += i;

        } 
        System.out.println(sum); // 100以内的和 -> 2550

        // 我愿称之为杰作！ -> 查看100以内数对3/5/7整除的情况
        // 使用print可以避免如此复杂！
        for(int i = 1; i <= 150; i++){
            if(i % 3 == 0){
                if(i % 5 == 0){
                    if(i % 7 == 0){
                        System.out.println(i + " foo" + " biz" + " baz");
                    }
                    else{
                        System.out.println(i + " foo" + " biz");
                    }
                }
                else{
                    if(i % 7 == 0){
                        System.out.println(i + " foo" + " baz");
                    }
                    else{
                        System.out.println(i + " foo" );
                    }
                }
            }
            else if(i % 5 == 0){
                if(i % 7 == 0){
                    System.out.println(i + " biz" + " baz");
                }
                else {
                    System.out.println(i + " biz");
                }
            }
            else if(i % 7 == 0){
                System.out.println(i + " baz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}


