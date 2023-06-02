package Stack;// 值得仔细揣摩！

public class Calculator {

    public static void main(String[] args) {
        // 表达式
        String expression = "32+24*6-29"; // 中缀表达式
        // 数栈 and 符号栈
        ArrayStack2 numStack = new ArrayStack2(10); // 无法从 static 上下文引用 'Stack.Calculator.this' -> 括号问题
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0; // 遍历索引
        int num1 = 0;
        int num2 = 0;
        // 使用int！
        int oper = 0;
//        char oper = '0'; // 操作符，定义为char！
        int res = 0; // 结果
        char ch = ' '; // 每次遍历得到字符
        String keepNum = ""; // 用于拼接<多位数>
        // 开始while循环的扫描expression
        while (true) {
            // 依次得到expression的每一个字符
//            ch = expression.substring(index, index+1).charAt(0);
            /*
            3 存入数字栈

             */
            ch = expression.charAt(index); // 按index取出字符
            if (operStack.isOper(ch)) { // 判断是否为运算符
                if (!operStack.isEmpty()) { // 运算符 -> 判断运算符栈是否为空
                    // 运算符 -> 栈不为空 -> 判断与栈内运算符的优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        /*
                        当前操作符的优先级小于或者等于栈中的操作符:
                        1. 就从栈中pop出两个数，进行运算
                        2. 当前的操作符入符号栈
                         */
                        num1 = numStack.pop(); // TODO num1 为6，已经pop出， 为什么还会出现在栈里？
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        /*
                        TODO 是否需要将 运算得到的数push入数栈？ -> 需要
                         */
                        numStack.push(res); // push结果
                        operStack.push(ch); // push当前操作符
                    } else {
                        /*
                        当前操作符的优先级大于栈中的操作符:
                        1. 当前的操作符入符号栈
                         */
                        operStack.push(ch);
                    }
                } else { // 符号栈为空，符号直接入符号栈
                    operStack.push(ch);
                }
            } else { // 数字，不是操作符
                /*
                如果是数，则直接入数栈
                1. 多位数的处理！
                2. 在处理数时，需要向expression的表达式的index后再看一位，如果是数继续扫描！
                   如果是字符串，就入栈！
                3. 创建字符串序列keepNum用于拼接
                 */
                keepNum += ch;
                // 判断ch是否为最后一位，如是，直接入数栈
                if (index == expression.length() - 1) { // ch是最后一位！
                    numStack.push(Integer.parseInt(keepNum));
                } else { // ch不是最后一位！
                    // TODO 调用这些方法时，是否可以使用numStack？ 是否可以声明为静态方法？
                    if (operStack.isOper(expression.charAt(index + 1))) { // 查看的是ch的下一位！ 而不是 index！
                        // 使用包装类的parstInt方法将 "123" -> 123
                        // parse : <计>语法分析，语法分析结果;
                        numStack.push(Integer.parseInt(keepNum)); // NumberFormatException, 数字格式化异常，说明在提取数字字符串时出现错误
                        // 重要！keepNum需要清空
                        keepNum = "";
                    }
                }
                // ch为char，字符'1'的char值是49，以此类推...
                // '3' 51 -> 存入numStack中的数为3
//                numStack.push(ch - '0'); 已废除
            }
            // 当前字符已经处理完毕，index + 1，并判断是否扫描到expression(表达式)最后
            index++;
            if (index >= expression.length()) {
                break; // 扫描结束
            }
        }
            /*
            1. 当表达式扫描完毕后，顺序的从数栈和符号栈中pop出相应的数和符号，并运行
            2. 如果符号栈为空，则计算到最后的结果
            3. 最后在数栈中只有一个数字，就是表达式的结果
             */
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper); // 1. 计算结果
            numStack.push(res); // 2. 将计算结果入栈！

        }


        // 将最后的数pop出即为结果！
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d", expression, res2);
    }

}
    // 栈 -> 需要扩展功能

class ArrayStack2 {
    private int maxSize; // 大小
    private int[] stack; // 数组模拟栈
    private int top = -1; // 栈顶，初始化为-1

    // 构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        // 将大小传入数组模拟栈，创建一个新数组
        stack = new int[this.maxSize];
    }
    // New3. 查询栈顶元素（不pop出栈）
    public int peek() {
        return stack[top];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈 push
    public void push(int value) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 pop
    public int pop() {
        if (isEmpty()) {
            try {
                System.out.println("pop时，栈空！");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // 有返回值的情况下 return 不适用，建议抛出异常！ C + A + T
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈（从栈顶往下遍历）
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    // New1. 返回运算符的优先级 -> 数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') { // TODO ! 这边应该为 + - 号！
            return 0;
        } else {
            return -1;
        }
    }

    // New2. 判断是否为运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // New3. 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; // res用来存放计算结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; // 后pop出的数为减数
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break; // TODO 增加默认选项
        }
        return res;
    }

}



