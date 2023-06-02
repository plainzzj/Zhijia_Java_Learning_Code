package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotation {
    public static void main(String[] args) {
        /*
        完成一个中缀表达式 -> 后缀表达式的功能
         */
        String expression = "(3+4)*5-6";
        List<String> strings = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的list：" +strings);
        // [(, 3, +, 4, ), *, 5, -, 6]

        System.out.println("后缀表达式对应的list：" + parseSuffixExpression(strings));
        // [3, 4, +, 5, *, 6, -]

        /*
        // 0. 定义一个 逆波兰表达式：
        // (3+4)*5-6 -> 3 4 + 5 * 6 -
        // 其中，逆波兰表达式作用的 数字和符号使用空格隔开~
        String suffixExpression = "3 4 + 5 * 6 - ";

        // 1. 先将字符串放入 ArrayList 中
        List<String> rpnlist = getListString(suffixExpression);
        System.out.println(rpnlist);
        /*
        [3, 4, +, 5, *, 6, -]
         * /
        // 2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
        int res = calculate(rpnlist);
        System.out.println(res);
                /*
                29
                 * /
        */
    }
    // 将得到的中缀表达式对应的List -> 后缀表达式对应的List
    public static List<String> parseSuffixExpression(List<String> ls){ // 应为标识符：形参列表中包含形参类型和形参名
        // 定义两个栈
        Stack<String> s1 = new Stack<>(); // 符号栈
//        Stack<String> s2 = new Stack<>(); // 存储中间过程的栈s2
        // 由于栈s2在整个转换过程中没有pop操作，而且后续需要逆序输出： 使用List代替
        List<String> s2 = new ArrayList<>(); // 存储中间过程的栈s2

        // 遍历ls [(, 3, +, 4, ), *, 5, -, 6]
        for (String item: ls){
            // 如果是数，加入s2
            /*
             \ 表示转义，故\\ 表示反斜杠
             \d+ 表示匹配一个或多个数字
             d 表示匹配任意数字字符
             + 表示匹配前面的字符集合一次或者多次
             */
            if(item.matches("\\d+")){
                s2.add(item);
            } else if(item.equals("(")){ // 如果是左括号，加入s1
                s1.push(item);
            } else if(item.equals(")")){ // 如果是右括号，依次弹出s1栈顶的运算符，压入s2，直到遇到左括号为止，丢弃这对括号
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); // 重要！ 丢弃s1中的左括号！
            } else{ // 是运算符，考虑优先级的问题！
                // item的优先级 <= 栈顶的优先级，将s1栈顶的运算符弹出并压入s2中，再次与s1中心的栈顶运算符比较
                // 方法：比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                // 还需要将item入栈
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符一次弹出并加入s2：
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2; // 由于存放在list中，故按顺序输出即为对应的后缀表达式
    }
    // 将中缀表达式 转为 对应的 list
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int i = 0; // 指针，用于遍历中缀表达式字符串ls
        String str; // 对多位数进行拼接
        char c; // 遍历到的字符
        do{
            // 如果c非数字，加入ls
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else{ // 如果c是数字，需要考虑多位数
                // 需要将临时字符串str置空
                str = "";
                while (i < s.length() && ((c=s.charAt(i)) <= 57 && (c=s.charAt(i)) >= 48 )){
                    str += c; // 拼接
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls; // 返回
    }

    //
    public static List<String> getListString(String suffixExpression){
        // 将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        /*
        在Java中，可以通过接口来定义函数的返回类型，这样就可以返回任何实现了该接口的对象。
        同样的道理，可以通过接口来定义函数的形参，这样就可以接收任何实现了该接口的对象。
         */
        List<String> list = new ArrayList<>();
        // 遍历分割字符串得到的字符串数组，将其添加入ArrayList动态数组，并返回
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    // 完成对逆波兰表达式的运算 -> 对 list 的遍历
    public static int calculate(List<String> list){
        // 栈，一个即可
        Stack<String> stack = new Stack<>();
        // 遍历list
        for (String item : list) {
            // 使用正则表达式来取出数
            if(item.matches("\\d+")) { // 多位数
                // 入栈
                stack.push(item);
            } else{ // 符号
                // pop出两个数，运算后入栈
                // 字符串转Int -> Integer.parseInt
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                // equals() 方法是 Java 中的一个方法，用于判断两个对象是否相等。该方法定义在 Object 类中.
                // String类中重写了这个方法用以比较两个字符串的内容是否相同
                if(item.equals("+")){
                    res = num1 + num2;
                } else if(item.equals("-")){
                    res = num1 - num2;
                } else if(item.equals("*")){
                    res = num1 * num2;
                } else if(item.equals("/")){
                    res = num1 / num2;
                } else{
                    throw new RuntimeException("运算符有误");
                }
                // 将结果入栈 (Integer.toString 将 Int -> 字符串)
                stack.push((Integer.toString(res)));

            }

        }
        // (Integer.parseInt 将 字符串 -> Int)
        return Integer.parseInt(stack.pop());
    }
}

// 返回优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 2;
    private static int MUL = 3;
    private static int DIV = 4;

    public static  int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }
}

