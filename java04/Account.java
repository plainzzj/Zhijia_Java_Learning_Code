package java04;

import javax.print.event.PrintEvent;

public class Account {
    private int id;
    private double balance;
    private double AIR;

    // 构造器
    public Account(){
        
    }
    public Account(int id, double balance, double AIR){
        this.id = id;
        this.balance = balance;
        this.AIR = AIR;

    }
    // 获取值的方法
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getAIR(){
        return AIR;
    }

    // 设置值的方法
    public void setId(int id) {
        this.id = id;  
    }
    public void setBalance(double balance) {
        this.balance = balance;  
    }
    public void setAIR(double AIR) {
        this.balance = AIR;  
    }

    // 其他方法
    public double getMonthlyInterest() {
        return balance * AIR / 12;  
    }
    public void withdraw(double amount) { // 取钱
        System.out.println("现有余额：" + balance);
        if(balance >= amount){
        balance = balance - amount;
        System.out.println("取出：" + amount + "    余额：" + balance);
        }else{System.out.println("余额不足");}
        System.out.println("***************************");
        
    }
    public void deposit(double amount) { // 存钱
        System.out.println("现有余额：" + balance);
        balance = balance + amount;
        System.out.println("存入：" + amount + "    余额：" + balance);
        System.out.println("***************************");

    }


    
}
