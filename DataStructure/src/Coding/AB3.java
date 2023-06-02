package Coding;
import java.util.*;

public class AB3  {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        /*
        给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
        括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
        */
        /*
        1. 建立两个栈 -> 错误的！ 一个栈，一个数组！
        */
        boolean flag = true;
        ArrayStack left = new ArrayStack(s.length());
        // ArrayStack right = new ArrayStack(s.length());
        // char[] right = new char[s.length()];
        List<Character> right = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(c == '(' || c =='[' || c == '{'){
                left.push(c);
            }else if(c == ')' || c ==']' || c == '}'){
                right.add(c); // 剩余的都是Null
            }
        }
        int numLeft = 0;
        int numRight = 0;
        for(Character c : left.arraystack){ // 这里只能使用Object，因为Null不是char类型！
            //  second type: <nulltype>(compiler.err.operator.cant.be.applied.1)
            /*
            在Java中，null是一个特殊的字面量，表示一个对象引用不指向任何对象。
            null不是关键字，而是null类型的特殊字面量。
            null可以转换为任何引用类型，但不能转换为任何基本类型，例如int或boolean。
            */
            if(c == 00){ // NUL是终止符！不是null！
                break;
            }else{
                numLeft++;
            }
        }
        // numRight = chars.length - numLeft;
        numRight = right.size();
        if(numLeft != right.size()){
            flag = false;

        }else{
            for(int i = 0; i < Math.max(numLeft, numRight); i++){
                char templeft = left.pop();
                char tempright = right.get(i);
                if(templeft == 'f' || tempright == 'f'){
                    flag = false;
                    break;
                }
                if(templeft == '(' && tempright != ')'){
                    flag = false;
                    break;
                }else if(templeft== '[' && tempright != ']'){
                    flag = false;
                    break;
                }else if(templeft == '{' && tempright != '}'){
                    flag = false;
                    break;
                }else{
                    continue;
                }

            }
        }

        return flag;
    }
}

class ArrayStack{
    int maxSize;
    char[] arraystack;
    int top = -1;
    // 构造函数
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        arraystack = new char[maxSize];
    }
    // push
    public void push(char c){
        top++;
        arraystack[top] = c;

    }
    // pop
    public char pop(){
        if(top == -1){
            // throw new Exception("false");
            return 'f';
        }else{
            char popNum = arraystack[top];
            top--;
            return popNum;

        }

    }
}