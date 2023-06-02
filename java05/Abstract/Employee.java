package java05.Abstract;

abstract public class Employee {
    private String name;
    private int id;
    private int salary;

    public Employee(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    

    // Abstract methods do not specify a body -> 抽象类不能有函数体
    abstract public void work();
}

// The type Manager must implement the inherited abstract method Employee.work()
// 必须重写work方法
class Manager extends Employee{
    int bonus;
    @Override
    public void work() {
        System.out.println("Manager is Working!");
        
    }

}
