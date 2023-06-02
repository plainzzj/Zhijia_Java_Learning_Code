package Project01;


public class FamilyAccount {
    public static void main(String[] args) {
        String[][] home = new String[5][4];
        // 设置标头
        home[0][0] = "收支";
        home[0][1] = "账号总金额";
        home[0][2] = "收支金额";
        home[0][3] = "说明";
        // 定义一个sum记录总金额
        int sum = 10000;
        // 显示主界面
        while (true) {
            // 主界面内容
            System.out.println("1.收支明细");
            System.out.println("2.登记收入");
            System.out.println("3.登记支出");
            System.out.println("4.退出");
            System.out.print("请选择1-4：");
            // 读取用户输入字符：1-4
            char choice = Utility.readMenuSelection();
            switch (choice) {
                case '1':
                    System.out.println("----------------收支明细----------------");
                    for (int i = 0; i < home.length; i++) {
                        for (int j = 0; j < home[i].length; j++) {
                            if (home[i][j] == null) {
                            } else {
                                System.out.print(home[i][j] + "  |  ");
                            }
                        }
                        System.out.println();
                        System.out.println("---------------------------------------");
                    }
                    System.out.println("返回首页");
                    System.out.println("请输入Y/N");
                    char goBack1 = Utility.readConfirmSelection();
                    if (goBack1 == 'Y') {
                        break;
                    } else {
                        System.out.println("感谢你的使用！");
                        return;
                    }
//                    break;
                case '2':
                    System.out.println("--------登记收入--------");
                    for (int i = 1; i < home.length; i++) {
                        if (home[i][2] == null) {
                            home[i][0] = "收入";
                            System.out.println("请输入金额");
                            int income = Utility.readNumber();
                            sum += income;
                            home[i][1] = String.valueOf(sum);
                            home[i][2] = String.valueOf(income);
                            System.out.println("请输入原因");
                            String cause = Utility.readString();
                            home[i][3] = cause;
                            break;
                        }
                    }
                    System.out.println("返回首页");
                    System.out.println("请输入Y/N");
                    char goBack2 = Utility.readConfirmSelection();
                    if (goBack2 == 'Y') {
                        break;
                    } else {
                        System.out.println("感谢你的使用！");
                        return;
                    }
                case '3':
                    System.out.println("--------登记支出--------");
                    for (int i = 1; i < home.length; i++) {
                        if (home[i][2] == null) {
                            home[i][0] = "支出";
                            System.out.println("请输入金额");
                            int income = Utility.readNumber();
                            sum -= income;
                            home[i][1] = String.valueOf(sum);
                            home[i][2] = String.valueOf(income);
                            System.out.println("请输入原因");
                            String cause = Utility.readString();
                            home[i][3] = cause;
                            break;
                        }
                    }
                    System.out.println("返回首页");
                    System.out.println("请输入Y/N");
                    char goBack3 = Utility.readConfirmSelection();
                    if (goBack3 == 'Y') {
                        break;
                    } else {
                        System.out.println("感谢你的使用！");
                        return;
                    }
                case '4':
                    System.out.println("退出程序");
                    System.out.println("请输入Y/N");
                    char goBack4 = Utility.readConfirmSelection();
                    if (goBack4 == 'Y') {
                        System.out.println("--------正在退出--------");
                        System.out.println("      感谢你的使用！     ");
                        System.out.println("--------退出成功--------");
                        return;
                    } else {
                        break;
                    }
            }
        }
    }
}
