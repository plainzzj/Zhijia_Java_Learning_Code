package java05.Interface;

public class NetWorkTest {
    public static void main(String[] args) {

        // 真实的服务器（被代理类）
        Server s1 = new Server();
        // server -> network
        ProxyServer ps1 = new ProxyServer(s1);

        // 表面上：代理服务器联网操作  -> server 没有显示的调用browse 
        // 实际上：真实服务器联网操作  -> 代理模式！
        // 通过代理类创建被代理对象，然后调用
        /*
        Check!!!
        ProxyServer!
        Server!
         */
        ps1.browse();
        
    }
    
}

interface NetWork{
    public void browse();
}


// 被代理类
class Server implements NetWork{

    @Override
    public void browse() {
       System.out.println("Server!"); 
    }
    
}

// 代理类
class ProxyServer implements NetWork{

    // 一个NetWork类型的变量
    private NetWork work;

    // 构造方法：需要被代理类参与
    public ProxyServer(NetWork work){
        this.work = work;
    }
    
    // 代理服务器的其他方法
    public void check(){
        System.out.println("Check!!!");
    }
    @Override
    public void browse() {
        check();
        System.out.println("ProxyServer!"); 

        work.browse();
     }
    
}