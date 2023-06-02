package java03;
/*
 * 类中属性的使用
 */
public class StudentTest { 
    // 继承测试 ST类的属性
    public int test1 = 1;
    public int test2 = 2;

    public char test3 = 'a';

    // 构造函数
    public StudentTest(){
    }

    // 在父类构造函数中定义了一个新的构造函数
    public StudentTest(int test1, int test2){
        this.test1 = test1;
        this.test2 = test2; 

    }
    public static void main(String[] args) {
        // 声明一个 student 类型的数组：String[] arr = new String[20]{};
        // Cannot define dimension expressions 
        // when an array initializer is provided
        // 去掉大括号
        Student1[] s = new Student1[20];
        for(int i = 0; i < s.length; i++){
            s[i] = new Student1();
            s[i].number = i + 1;
            // Type mismatch: cannot convert from double to int
            // (int) 强制类型转换
            s[i].state = (int)(Math.random() * 6 + 1);
            s[i].score = (int)(Math.random() * 100);
        }
        // 打印测试
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i]); // java03.Student@5305068a 地址值
            System.out.println(s[i].info());
        }

        // 打印3年级学生信息
        for(int i = 0; i < s.length; i++){
            if(s[i].state == 3){
                System.out.println(s[i].info());
            }
            }
        
        // 冒泡排序学生成绩
        // 20个学生，19轮冒泡
        for(int i = 0; i < s.length - 1; i++){
            for(int j = 0; j < s.length - i - 1; j++){
            if(s[j].score > s[j+1].score){
                Student1 temp = s[j];
                s[j] = s[j+1];
                s[j+1] = temp;
            }  
        }  
        }
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i].info());
            }

        
    }
    // 继承测试
    public void func1() {
       System.out.println("father1");     
            
    }

    public void func2() {
        System.out.println("father2");     
             
     }
    }


/*
 * Exception in thread "main" java.lang.NoSuchFieldError: number
 * at java03.StudentTest.main(StudentTest.java:13)
 * 文件名相同,依赖的文件名与自身写的相同,导致数据重复引用错误?
 * 在PersonTest.java中已存在
 */
// The public type Student1 must be defined in its own file
// 前加 public 需要在自己的同名文件下
// 内部类，不常用
class Student1{
    int number;
    int state;
    int score;

    // 显示学生信息的方法
    public String info(){
        return " 学号：" + number + " 年级：" + state + " 成绩："+ score;
    }
}

