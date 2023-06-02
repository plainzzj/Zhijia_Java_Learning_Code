package java01;

// // 自己实现
// class primeNum {
//     public static void main(String[] args){
//         // 获取当前时间
//         long start = System.currentTimeMillis();
//         for(int i = 2; i <= 100000; i++){
//             for(int j = 2; j < i; j++){
//                 if(i % j == 0){
//                     break;
//                 }   
//                 else if(j == i-1){
//                     System.out.println(i); 
//                 }
//             }
//             }
//         // 获取执行完时间
//         long end = System.currentTimeMillis();

//         // Time: 1966ms
//         System.out.println("Time: " + (end - start) + "ms");   
//         }
//     }

// 官方实现
// class primeNum {
//     public static void main(String[] args){
//         // 获取当前时间
//         long start = System.currentTimeMillis();
//         boolean isFlag = true; 
//         for(int i = 2; i <= 100000; i++){
//             for(int j = 2; j < i; j++){
//                 if(i % j == 0){
//                     isFlag = false;
//                 } 
//             }  
//         if(isFlag == true){
//             System.out.println(i);     
//         }
//             isFlag = true;

//     }
//     // 获取执行完时间
//     long end = System.currentTimeMillis();

//     // Time: 14583ms
//     System.out.println("Time: " + (end - start) + "ms");  
// }
// }

//效率优化
// 官方实现
// class primeNum {
//     public static void main(String[] args){
//         boolean isFlag = true; 

//         // 获取当前时间
//         long start = System.currentTimeMillis();
//         for(int i = 2; i <= 100000; i++){

//              // 使用根号更快捷 -> Math.sqrt(i)

//             for(int j = 2; j < i/2; j++){
//                 if(i % j == 0){
//                     isFlag = false;
//                     break; // 优化一：只对本身非质数的自然数是有效的
//                 } 
//             }  
//         if(isFlag == true){
//             System.out.println(i);     
//         }
//             isFlag = true;

//     }
//     // 获取执行完时间
//     long end = System.currentTimeMillis();

//     // Time: 1494ms
//     System.out.println("Time: " + (end - start) + "ms");
// }
// }

// //效率优化 二
// // 官方实现
// class primeNum {
//     public static void main(String[] args){
//         boolean isFlag = true; 

//         // 获取当前时间
//         long start = System.currentTimeMillis();
//         for(int i = 2; i <= 100000; i++){

//              // 使用根号更快捷 -> Math.sqrt(i)

//             for(int j = 2; j < Math.sqrt(i); j++){ // 优化二：使用根号
//                 if(i % j == 0){
//                     isFlag = false;
//                     break; // 优化一：只对本身非质数的自然数是有效的
//                 } 
//             }  
//         if(isFlag == true){
//             System.out.println(i);     
//         }
//             isFlag = true;

//     }
//     // 获取执行完时间
//     long end = System.currentTimeMillis();

//     // Time: 894ms
//     System.out.println("Time: " + (end - start) + "ms");
// }
// }

// //效率优化 三
// // 官方实现
// class primeNum {
//     public static void main(String[] args){
//         boolean isFlag = true; 

//         // 获取当前时间
//         long start = System.currentTimeMillis();

//         // 初始化质数个数
//         int num = 0;
//         for(int i = 2; i <= 100000; i++){

//              // 使用根号更快捷 -> Math.sqrt(i)

//             for(int j = 2; j <= Math.sqrt(i); j++){ // 优化二：使用根号
//                 if(i % j == 0){
//                     isFlag = false;
//                     break; // 优化一：只对本身非质数的自然数是有效的
//                 } 
//             }  
//         if(isFlag == true){
//             // System.out.println(i);
//             num++;     
//         }
//             isFlag = true;

//     }
//     // 获取执行完时间
//     long end = System.currentTimeMillis();

//     // Time: 16ms
//     System.out.println("Time: " + (end - start) + "ms");
//     System.out.println("Number: " + num);

//     // Number: 9657错误！ j <= Math.sqrt(i), 不能忘记 = ！！！
// }
// }

// 效率优化 四
// 官方实现
class primeNum {
    public static void main(String[] args){ // 计算10W以内的质数的个数

        // 获取当前时间
        long start = System.currentTimeMillis();

        // 初始化质数个数
        int num = 0;
        label:for(int i = 2; i <= 100000; i++){

             // 使用根号更快捷 -> Math.sqrt(i)

            for(int j = 2; j <= Math.sqrt(i); j++){ // 优化二：使用根号
                if(i % j == 0){
                    // break; // 优化一：只对本身非质数的自然数是有效的
                    continue label; //使用label直接跳过最外层循环！
                } 
            }  
            num++;     
        }

    
    // 获取执行完时间
    long end = System.currentTimeMillis();

    // Time: 16ms
    System.out.println("Time: " + (end - start) + "ms");
    System.out.println("Number: " + num);
}
    // Number: 9657错误！ j <= Math.sqrt(i), 不能忘记 = ！！！
}