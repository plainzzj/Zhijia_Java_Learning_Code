package java01;


// ————————————————————————————————————————————————————————————————————————————————0404


// The file 'Nineninetable'is not executable, please select a main class you want to run
// 文件Ninenietable不可执行，请选择要运行的主类
// 问题出在后缀，需为 .java

class NinenineTable {
    public static void main(String[] args){
        for(int i = 1; i <= 99; i++){
            System.out.println(); // 换行
            for(int j = 1; j <=i; j++){
                System.out.print( i + " * " + j + " = " + i*j + " "); // 乘法表
            }
        }
    }
}
