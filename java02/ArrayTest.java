package java02;

import java.util.Scanner;

public class ArrayTest {
    public static void  main(String[] args) {
        // 使用scanner读取学生个数
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the number of students:");
        int number = scanner.nextInt();
        // 创建数组存储学生成绩：动态初始化
        int[] scores = new int[number];
        // 给数组中的元素赋值
        // 获取数组中的元素的最大值：最高分
        // 在遍历数组张元素的时候即可同时计算元素中的最大值
        int maxScore = 0;
        System.out.println("please input the scores of ench student:");
        for(int i = 0; i < scores.length; i++){
            scores[i] = scanner.nextInt();
            if(maxScore < scores[i]){
                maxScore = scores[i];
            }
        }
        // 根据每个学生成绩与最高分的插值，得到每个学生的等级，并输出等级和成绩
        char level;
        for(int i = 0; i < scores.length; i++){
            if(maxScore - scores[i] <= 10){
                level = 'A';
            }else if(maxScore - scores[i] <= 20){
                level = 'B';
            }else if(maxScore - scores[i] <= 30){
                level = 'C';
            }else level = 'D';
            System.out.println("Student" + i +"'s score is " + scores[i] 
            + ", the level is " + level);


        }
        

        
        


    }
}
