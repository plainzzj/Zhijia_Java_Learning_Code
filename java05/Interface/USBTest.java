package java05.Interface;

public class USBTest {
    public static void main(String[] args) {
        // The method transferData(Flash) is undefined for the type USBTest
        // 前面需要+类名： static方法，不需要实例化
        // new Flash()： 接口不可以造对象，只能造实现类的对象：多态性
        // 1. 接口的非匿名实现类的匿名对象
        Computer.transferData(new Flash());
        /*
         * Start!
         * ***
         * Stop!
         */
        // 2. 接口的匿名实现类的非匿名对象
        USB phone = new USB(){
            @Override
            public void start() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'start'");
            }

            @Override
            public void stop() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'stop'");
            }
            
        };
        Computer.transferData(phone);
        // 4. 接口的匿名实现类的匿名对象
        Computer.transferData(new USB() {

            @Override
            public void start() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'start'");
            }

            @Override
            public void stop() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'stop'");
            }
            
        });


    }
    
}

interface USB{

    void start();
    void stop();
}

class Flash implements USB{

    @Override
    public void start() {
        System.out.println("Start!");
    }

    @Override
    public void stop() {
        System.out.println("Stop!");
    }
    
}

// Illegal modifier for the class Computer; only public, abstract & final are permitted
class Computer{
    static public void transferData(USB usb){
        usb.start();
        System.out.println("***");
        usb.stop();
    }
}

