package java01;

// ————————————————————————————————————————————————————————————————————————————————0404

class SwithCase {
    public static void main(String[] args){
    
        int num = 2;
        switch(num){
            case 0:
            System.out.print("zero");
            case 1:
            System.out.print("one");
            case 2:
            System.out.print("two");
            // without break: output two three...
            break;
            case 3:
            System.out.print("three");
        }
    }
}