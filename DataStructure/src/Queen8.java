public class Queen8 {
    // 循环总次数！
    int num = 1;
    // 皇后数
    int max = 8;
    // array -> 保存皇后放置位置的结果
    int[] array = new int[max];
    public static void main(String[] args) {

        // 测试
        Queen8 queen8 = new Queen8();
        queen8.check(0); // 把第一个皇后放入！ 开始执行！

    }
    // 写一个方法 -> 放置第n个皇后，判断是否合规
    private void check(int n){

        if(n == max){ // n = 8 8个皇后都放好了
            print();
            System.out.println("nums = " + num);
            num++;
            return;
        }
        // 依次放入皇后并且判断是否冲突
        for (int i = 0; i < max; i++){
            // 先把当前的皇后n，放到该行的第一列：
            array[n] = i;
            // 判断是否冲突
            if(judge(n)){ // 不冲突！
                // 接着放n + 1个皇后，即开始【递归】!
                check(n + 1); // check循环了8次！
            }else{ // 冲突！ -> 把当跟前的皇后n，放在该行的下一列
                continue;
            }
        }
    }
    // 写一个方法 -> 当放置第n个皇后，检测该皇后是否和前面已摆放的皇后冲突： 一共调用一万多次
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            // 注意abs的用法！
            if(array[i] == array[n] || Math.abs(array[n]-array[i])  == + Math.abs(n - i)){ // 列的位置相同 || 列差 == 行差
                return false;
            }

        }
        return true;
    }
    // 写一个方法 -> 打印摆放的位置
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

/*
7 3 0 2 5 1 6 4
nums = 92 --> bingo!
 */
