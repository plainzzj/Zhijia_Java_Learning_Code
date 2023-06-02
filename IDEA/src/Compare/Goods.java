package Compare;

// 商品类 -> 对商品进行排序
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        // 指明商品按照什么方式进行排序 -> 自然排序
        if(o instanceof Goods){
            // 将商品类型进行强制转换
            Goods goods = (Goods)o;
            // 方式1
            if(this.price > goods.price){
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            }else{
                return 0;
            }
            // 方式2
//            return Double.compare(this.price,goods.price)
        }

//        return 0;
        // 当传入信息不正确是抛出异常
        throw new RuntimeException("传入的数据类型不正确！");
    }
}
