package File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OtherStreamTest {
    /*
    标准输入流、输出流 System.in(键盘输入)/ System.out(控制台输出)
    InputStream
    PrintStream
    setIn() setIn() -> 指定输入/输出流
     */
    /*
    Test: 单元测试 -> 无法从键盘输入
     */
    public static void main(String[] args) throws IOException {
        // 从键盘输入：Scanner，使用next方法
        // 从键盘输入：System.in 更底层 -> 转换流 -> BufferedReader的readline
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String data;
        while(true){
            System.out.println("Please input:");
            data = br.readLine();
            // 更好的写法： "e".equalsIgnoreCase(data)
            if(data.equalsIgnoreCase("e") || data.equalsIgnoreCase("exit")){
                System.out.println("Over");
                break;
            }
            System.out.println(data.toUpperCase());
        }

        br.close();
        /*
        Please input:
            asdfsdgddfasdfag
        ASDFSDGDDFASDFAG
        Please input:
            e
        Over
         */

    }
}
