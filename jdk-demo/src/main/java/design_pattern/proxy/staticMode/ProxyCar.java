package design_pattern.proxy.staticMode;

public class ProxyCar implements ICar{

    private ICar iCar;
    public ProxyCar(ICar iCar) {
        this.iCar = iCar;
    }

    public void drive() {
        System.out.println("proxy start ready,execute target object method");
        iCar.drive();
        System.out.println("proxy execute target object method end");
    }

}
