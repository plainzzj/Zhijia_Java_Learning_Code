package java04;


// Implicit super constructor Account() is undefined for default constructor.
// Must define an explicit constructor
// 在父类中增加一个空构造函数即可。
public class CheckAccount extends Account{
    // 独有的属性
    private double overdraft;
    // 在属性中定义一个值用来存放可透支的总额
    // 使用static来存放常量？
    static double maxOverdraft;


    // 构造方法
    public CheckAccount(int id, double balance, double AIR, double overdraft){
        // 调用父类的构造方法
        super(id, balance, AIR);
        this.overdraft = overdraft;
        // 在构造方法中将输入的透支额度存放入变量：maxOverdraft
        // The static field CheckAccount.
        // maxOverdraft should be accessed in a static way
        this.maxOverdraft = overdraft;
    }

    // 重写withdraw方法
    @Override
    public void withdraw(double amount) {
        // 父类中的属性 balance 是private权限，无法直接使用
        // 获取属性方法
        
        if(getBalance() >= amount){
        // 方法一：
        // 设置新的balance，使用setBalance方法
        // setBalance(getBalance() - amount);

        // 方法二：调用父类中已经写好的withdraw方法：
        super.withdraw(amount);
        }else if(overdraft + getBalance() >= amount){
            // 先设置透支额度，再将账户的钱设置为空
            this.overdraft -= amount - getBalance();
            super.withdraw(getBalance());

            System.out.println("可透支额度：" + overdraft);
            // maxOverdraft值为0；
            System.out.println("已经透支了" + (maxOverdraft - overdraft));
            System.out.println("***************************");
        }else{
            System.out.println("not enough");
            System.out.println("***************************");
        }
        
        

    }
    
}
