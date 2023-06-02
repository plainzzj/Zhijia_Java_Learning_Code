package Coding;
import java.util.*;

public class AB2 {
    /*
    核心代码模式
    ACM模式
    */
    public boolean IsPopOrder(int [] pushA, int [] popA) {
        /*
        输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
        假设压入栈的所有数字均不相等。
        例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
        */

        /*
        思路分析
        1. 最先弹出的数的左边一定是压入顺序的倒序
        2. 最先弹出的数的右边可以随意 -> 不可以随意！ 123456 - 364521 -> 此方法行不通
        */
        // ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(popA)); // Java9
        if (pushA.length == 1) {
            return (pushA[0] == popA[0]);
        } else {
            boolean flag = true;
            ArrayList<Integer> popList = new ArrayList<Integer>(popA.length);

            for (int i : popA) {
                popList.add(i);
            }
            ArrayList<Integer> pushList = new ArrayList<Integer>();
            for (int i : pushA) {
                pushList.add(i);
            }
            // 当第一个元素刚push入就pop出时，需要排除掉：
            int startIndex = 0;
            for(int i = 0; i < popList.size(); i++){
                if(pushA[i] == popA[i]){
                    continue;
                }else{
                    startIndex = i;
                    break;
                }
            }
            int temp = popList.get(startIndex);
            int firstIndex = pushList.indexOf(
                    temp); // 这边需要得到pop出的第一个元素在push中的索引
            ArrayList<Integer> temp1 = new ArrayList<Integer>();
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            for (int i = startIndex; i < firstIndex; i++) { // 当第一个元素刚push如就pop出时，直接忽略！
                temp1.add(pushList.get(i));
            }
            for (int i = 0; i < popList.size(); i++) {
                if (temp1.contains(popList.get(i))) {
                    temp2.add(popList.get(i));
                }
            }
            if (temp1.size() !=
                    temp2.size()) { // 二者长度不同，说明pop和push过程中中有不同的元素！
                flag = false;
            } else {
                for (int i = 0; i < temp1.size(); i++) {
                    if (temp1.get(i) == temp2.get(temp1.size() - i - 1)) {
                        continue;
                    } else {
                        flag = false;
                    }
                }

            }
            return flag;

        }


    }
}
