package Generic;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    String orderName;
    int orderID;
    // 类的内部结构可以使用类的泛型
    T orderT;

    public Order() {
    }

    public Order(String orderName, int orderID, T orderT) {
        this.orderName = orderName;
        this.orderID = orderID;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderID=" + orderID +
                ", orderT=" + orderT +
                '}';
    }

    // 泛型方法：
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);

        }
        return list;

    }
}
