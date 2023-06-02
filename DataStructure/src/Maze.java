public class Maze {
    public static void main(String[] args) {
        // 2维数组模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表示墙
        for (int i = 0; i < 7; i++) { // 第一行和最后一行为1
            map[0][i] = 1;
            map[7][i] = 1;
        }
//        for (int i = 0; i < map.length; i++){
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//            /*
//            1 1 1 1 1 1 1
//            0 0 0 0 0 0 0
//            0 0 0 0 0 0 0
//            0 0 0 0 0 0 0
//            0 0 0 0 0 0 0
//            0 0 0 0 0 0 0
//            0 0 0 0 0 0 0
//            1 1 1 1 1 1 1
//             */
//        }
        for (int i = 0; i < 8; i++) { // 第一列和最后一列为1
            map[i][0] = 1;
            map[i][6] = 1;
        }
//        for (int i = 0; i < map.length; i++){
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//            /*
//            1 1 1 1 1 1 1
//            1 0 0 0 0 0 1
//            1 0 0 0 0 0 1
//            1 0 0 0 0 0 1
//            1 0 0 0 0 0 1
//            1 0 0 0 0 0 1
//            1 0 0 0 0 0 1
//            1 1 1 1 1 1 1
//             */
//        }
        map[3][1] = 1;
        map[3][2] = 1;
        // 使用递归函数给小球找路：
        setWay(map, 1, 1); // map是（二维数组）引用类型 -> 不管产生多少个栈，都是修改同一张地图
        // 输出新地图：
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
            /*
            1 2 0 0 0 0 1
            1 2 2 2 0 0 1
            1 1 1 2 0 0 1
            1 0 0 2 0 0 1
            1 0 0 2 0 0 1
            1 0 0 2 2 2 1
            1 1 1 1 1 1 1
             */
        }
    }

    // 使用递归回溯来给小球找路

    /**
     * @param map 地图
     * @param i   起始位置
     * @param j
     * @return 如果找到通路 -> true; 否则 -> false
     */

    // 1 表示墙 2 表示通 3 表示已经走过，但不通
    // 策略： 下 -> 右 -> 上 -> 左，走不通就回溯
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到
            return true;
        }
        if (map[i][j] == 0) { // 按照策略走
            map[i][j] = 2; // 假定该点可以走通
            if (setWay(map, i + 1, j)) { // 下
                return true;
            } else if (setWay(map, i, j + 1)) {// 右
                return true;
            } else if (setWay(map, i - 1, j)) {// 上
                return true;
            } else if (setWay(map, i, j - 1)) {// 左
                return true;
            } else {
                map[i][j] = 3; // 走不通，置3
                return false;
            }
        } else { // 如果map[i][j] != 0，可能是1（墙）,2（已走过）,3（走不通）
            return false; // 直接返回false！
        }


    }
}
