package design_pattern.proxy.staticMode;

public class InvokeClient {

    public static void main(String[] args) {
        // 1. 创建目标实现类
        ICar smallCar = new SmallCar();
        // 2. 创建代理类，传入目标类
        new ProxyCar(smallCar).drive();

    }
}
