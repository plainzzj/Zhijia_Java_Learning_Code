package Thread;

/*
银行有一个账户，两个储户，存3000，每次存1000，存3次。每次存完打印账户余额。

分析：
1. 是否是多线程问题？ 是，两个储户线程
2. 是否有共享数据？ 有，账户的余额
3. 是否有线程安全问题？ 有，需要考虑如何解决安全问题 -> 同步机制

 */
class Account{
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    // 存钱
    public  synchronized void deposite(double amt){
        if(amt > 0){
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功。余额为：" + balance);
        }
    }
}

class Custermer extends Thread{
    private Account acct;

    public Custermer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposite(1000);

        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Custermer c1 = new Custermer(acct);
        Custermer c2 = new Custermer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();


    }
}

/*
甲存钱成功。余额为：2000 (乙存了1000，莫名显示2000)
乙存钱成功。余额为：2000
甲存钱成功。余额为：4000
乙存钱成功。余额为：5000
甲存钱成功。余额为：6000
乙存钱成功。余额为：6000
 */
/*
public  synchronized void deposite 后：
甲存钱成功。余额为：1000
甲存钱成功。余额为：2000
甲存钱成功。余额为：3000
乙存钱成功。余额为：4000
乙存钱成功。余额为：5000
乙存钱成功。余额为：6000
 */