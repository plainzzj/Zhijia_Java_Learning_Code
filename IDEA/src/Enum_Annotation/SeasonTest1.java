package Enum_Annotation;

public class SeasonTest1 {
    public static void main(String[] args) {
        System.out.println(Season1.AUTUMN); // AUTUMN (不是地址值！)
        System.out.println(Season1.class.getSuperclass()); // class java.lang.Enum

        Season1 autumn = Season1.AUTUMN;
        // toString():
        System.out.println(autumn.toString()); // AUTUMN
        // values():
        Season1[] values = Season1.values();
        System.out.println(values); // [LEnum.Season1;@682a0b20 数组的地址
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            /*
            SPRING
            SUMMER
            AUTUMN
            WINTER
             */
        }
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
            /*
            NEW
            RUNNABLE
            BLOCKED
            WAITING
            TIMED_WAITING
            TERMINATED
             -> 线程的一些状态
             */

        }

        // valueOf(String objName): 根据提供的objName, 返回枚举类中的对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter); // WINTER

        winter.show(); // This is a winter


    }

}
interface Info{
    // 省略了 public abstract -> 接口定义抽象方法
    void show();
}
enum Season1 implements Info{ // 父类不是object，而是class java.lang.Enum
    // 多个对象之间，用逗号 -> 0. 提供当前枚举类的对象

    // 可以在每个对象中实现抽象类的方法
    SPRING("春","春暖花开"){
        @Override
        public void show() {
            System.out.println("This is a spring");
        }
    },
    SUMMER("夏","艳阳高照"){
        @Override
        public void show() {
            System.out.println("This is a summer");
        }
    },
    AUTUMN("秋","硕果累累") {
        @Override
        public void show() {
            System.out.println("This is a autumn");
        }
    },
    WINTER("冬","白雪皑皑") {
        @Override
        public void show() {
            System.out.println("This is a winter");
        }
    };
    // 1. 声明Season对象的属性: 需要用private final修饰
    private final String seasonName;
    private final String seasonDesc;
    // 2. 私有化类的构造器 (类的对象是确定的)
    private Season1(String seasonName, String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;

    }
    // 3. 提供当前枚举类的多个对象: 需要用public static final修饰


    // 4. 其他诉求：获取枚举类对象的属性， 提供ToString方法：(不需要重写！)
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//     情况一：重写接口中的抽象方法 (被四个枚举对象重写！)
    @Override
    public void show() {
        System.out.println("This is a season");

    }

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}