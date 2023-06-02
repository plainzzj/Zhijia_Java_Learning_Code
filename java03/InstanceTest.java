package java03;

public class InstanceTest {
    public static void main(String[] args) {
        // 对象的变量名： p
        Phone p = new Phone();
        p.playGame();
        p.sendEmail();

        // 匿名
        new Phone().sendEmail();
        new Phone().playGame();

        PhoneMall pm = new PhoneMall();
        pm.show(p);
        // 匿名对象的使用
        // 传入show定义后，也不再是匿名，而是有指定的栈中存放的变量
        pm.show(new Phone());


        
    }
    
}

class Phone{
    double price;
    public void sendEmail(){
        System.out.println("发送邮件");
    }

    public void playGame(){
        System.out.println("玩游戏");
    } 
}

class PhoneMall{
    public void show(Phone phone){
        phone.sendEmail();
        phone.playGame();
    }
}
