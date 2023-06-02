package java04;

public class AccountTest {
    public static void main(String[] args) {
        CheckAccount ca = new CheckAccount(1001, 20000, 0.005, 30000);
        ca.withdraw(10000);
        ca.withdraw(31000);

    }
    
}
