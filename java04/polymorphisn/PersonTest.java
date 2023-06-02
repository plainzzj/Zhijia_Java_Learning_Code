package java04.polymorphisn;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();
        
        Man m = new Man();
        m.eat();
        m.earnMoney();

        Woman w = new Woman();
        w.eat();
        w.goShopping();

        System.out.println("*************************");
        //********************************************************
        // 申明一个person类的变量：p2，但是设置（new）其为man -> 多态性
        // 对象的多态性（person的子类）
        // 父类的引用（p2）指向子类的对象（new Man()）
        Person p2 = new Man();
        // 多态的使用：当调用子父类同名同参数的方法时：虚拟方法调用
        // 子类重写父类的方法
        // 此时，进入eat()的内部结构：发现其还是父类自己的方法
        p2.eat(); // eat more! 
        
        Person pt = new Person();
        pt.func(new Man()); // eat more! // Humen can speak with ABC
        // m上上述定义的一个Man类（Person类的子类）的实例 -> 多态性！
        pt.func(m);
        // pt是一个类的实例，故其可以调用func1方法
        pt.func1(pt);
        pt.func1(m);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        // person中定义的属性id:1111 man中定义的属性id:2222
        // Person pt = new Person(); -> 对于属性，编译和运行只看左边
        // 属性没有多态性！
        System.out.println(p2.id); // 1111

        System.out.println("+++++++++++++++++++++++++++++++++++");

        // 对于子类自己独有的方法/属性无法调用 -> 编译时：p2是Person类型！
        // 内存空间中子类自己的方法，如earnMoney()是有的；
        // new Man()时，man子类自己的方法和属性都是加载到堆空间中的！

        // p2.earnMoney();

        // 赋值符号左右两边类型需一致（或可以类型提升）
        // Man m1 = p2; -> 强制类型提升！（向下转型）
        // 向上转型 -> 多态！
        Man m1= (Man)p2; // Duplicate local variable p2
        m1.earnMoney(); // make money!

        // 强转有风险！ 不一定能成功！-> 编译通过，运行不通过
        // java.lang.ClassCastException 类型转换异常！
        // Woman w1 = (Woman)p2;
        // w1.goShopping();

        // 父类无法强转成子类！
        // java.lang.ClassCastException: -> 编译通过，运行不通过
        // Person p4 = new Person();
        // Man m4 = (Man)p4;

        // 可以，第一句是多态性（向上转型）（子类 -> 爷类）
        // 第二句是向下转型（父类 -> 子类）
        // 编译运行都通过
        Object obj = new Man();
        Person p4 = (Person)obj;


        //instanceof:
        if(p2 instanceof Woman){
            Woman w1 = (Woman)p2;
            w1.goShopping();
            System.out.println("()()()Women()()()");
        }
        if(p2 instanceof Man){
            Man w1 = (Man)p2;
            w1.earnMoney();
            System.out.println("()()()men()()()");

            // 对于引用数据类型：比较的是两个引用数据类型变量的地址值
            System.out.println(w1 == p2); //true
            System.out.println(p2); // java04.polymorphisn.Man@279f2327
            System.out.println(w1); // java04.polymorphisn.Man@279f2327
            // man:2222 person:1111 
            // 属性不适用于多态 -》 子父类中不要定义重名的属性
            System.out.println(w1.id); // 2222
            System.out.println(p2.id); // 1111
        }





    }

    
}
