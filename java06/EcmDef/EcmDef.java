package java06.EcmDef;

public class EcmDef {
    public static void main(String[] args) {
        

        // Unhandled exception type EcDef -> 未处理的异常类型EcDef（非运行时异常）
        try {
            // 将输入的String[] args -> int
            // 将字符串参数解析为带符号的十进制整数。
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[0]);
            int result = ecm(i, j);
            System.out.println(result);
        } catch (EcDef e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println(e.getMessage());
        } catch(NumberFormatException e){
            System.out.println("数据类型不一致！");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数！");
        }catch(ArithmeticException e){
            System.out.println("除0！");
        }
        
    }

    // 抛出异常，必须处理，包括throws 和 try-catch
    public static int ecm(int i, int j) throws EcDef{
        // return i1/i2;
        if(i < 0 || j < 0) {
            throw new EcDef("请输入正数！");
        }
        return i/j;
    }
    
}
