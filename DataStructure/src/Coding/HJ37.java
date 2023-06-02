package Coding;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ37 {
    /*
    从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
    例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
    一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
    */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int num = 1;
            int[][] nums = new int[a][a]; // 构建第一行
            for (int i = 2; i <= a - 3; i++) {
                nums[0][i] = num;
                num++;
            }
            int start = 4;
            for (int i = 1; i <= a - 2; i++) { // 遍历每一行
                for (int j = start; j <= a - start ; j++) {
                    nums[i][j] = num;
                    num++;
                }
                start++;
            }
            int total = 1;
            for (int[] row : nums) {
                total += row[a - 1];
            }
            System.out.println(total);
        }

    }
}