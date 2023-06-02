package java01;

// ————————————————————————————————————————————————————————————————————————————————0404

class VariableTest{
    public static void main(String[] args){
        int myAge = 12;
        System.out.println(myAge);

        int myNumber; 
        myNumber = 1001;
        System.out.println(myNumber);

        byte smallNum = 100;
        System.out.println(smallNum);

        float bigNum = 12345.6789f;
        System.out.println(bigNum);

        char letter = 'a';
        System.out.println(letter);

        char unicode = '\u0043';
        System.out.println(unicode);

        // 损失精度
        double change = 12.3;
        int afterChange = (int)change;
        System.out.println(afterChange);

        //-128
        int i2 = 128;
        byte b = (byte)i2;
        System.out.println(b);



        
    }
}