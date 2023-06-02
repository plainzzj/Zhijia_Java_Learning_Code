// 稀疏数组
public class SparseArray {
    public static void main(String[] args) {
        // 11*11 棋盘
        int[][] chessArr1 = new int[11][11];
        // 1 黑子 2 白子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 两轮增强for循环
        for (int[] row : chessArr1) {
            for (int i : row) {
                // %d -> 十进制整数 \t -> 制表符 printf:格式化打印
                System.out.printf("%d\t", i);
                /*
                0	0	1	0	0	0	0	0	0	0	0
                0	0	0	2	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                0	0	0	0	0	0	0	0	0	0	0
                 */
            }
            System.out.println();
        }
        /*
        将二维数组转换为稀疏数组
         */
        // 1. 遍历二维数组，得到非0的数据的个数
        // 问题： 增强for中如何获取对应元素的索引？
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int i : row) {
                if(i != 0) sum++;
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 第一行赋值：
        sparseArr[0][0] = chessArr1.length; // 行数 -> 二维数组的长度
        sparseArr[0][1] = chessArr1[0].length; // 列数 -> 二维数组中一个元素的长度
        sparseArr[0][2] = sum; // 元素数

        // 遍历二维数组，将非零的值存放到spareArr中 -> 直接按照索引遍历！
        int num = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if(chessArr1[i][j] != 0){
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = chessArr1[i][j];
                    num ++;
                }
            }
        }
        System.out.println("得到的稀疏数组：");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
            /*
            11	11	2
            1	2	1
            2	3	2
             */
        }

        // 3. 将稀疏数组转换为二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 遍历行
        for (int i = 1; i < sparseArr.length; i++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }

        // 回复后的原始数据：
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

    }
}
