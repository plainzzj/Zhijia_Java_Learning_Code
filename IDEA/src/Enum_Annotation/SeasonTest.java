package Enum_Annotation;

public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
// 自定义枚举类
class Season{
    // 1. 声明Season对象的属性: 需要用private final修饰
    private final String seasonName;
    private final String seasonDesc;
    // 2. 私有化类的构造器 (类的对象是确定的)
    private Season(String seasonName, String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;

    }
    // 3. 提供当前枚举类的多个对象: 需要用public static final修饰
    public static final Season SPRING = new Season("春","春暖花开");
    public static final Season SUMMER = new Season("夏","艳阳高照");
    public static final Season AUTUMN = new Season("秋","硕果累累");
    public static final Season WINTER = new Season("冬","白雪皑皑");

    // 4. 其他诉求：获取枚举类对象的属性， 提供ToString方法：
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
