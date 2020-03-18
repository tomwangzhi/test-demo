package thread;

/**
 * 三个线程： CoffeStoreThread  Customer1 Customer2
 * 资源： coffee
 * Customer1 Customer2 等待  CoffeStoreThread 制作好咖啡后进行通知
 */
public class CoffeeStoreNoticeAndCustomeCarry {

    private static Object coffee = new Object();

    public static class CoffeStoreThread implements Runnable {

        @Override
        public void run() {

            // CoffeStoreThread 线程制作好coffe这个资源后通知所有的线程
            synchronized (coffee) {
                System.out.println("store begin make coffe");
                System.out.println("begin notice all customer");
                coffee.notifyAll();
                System.out.println("store notice end");
            }

        }
    }

    public static class Customer1 implements Runnable {

        @Override
        public void run() {
            // Customer1线程拥有coffee这个对象资源
            synchronized (coffee) {
                System.out.println(" customer begin order coffee");
                try {
                    System.out.println(Customer1.class.getName() +":wait coffee make");
                    coffee.wait();
                    System.out.println(Customer1.class.getName()+"wait coffe make finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static class Customer2 implements Runnable {

        @Override
        public void run() {
            // Customer2 线程拥有coffee这个资源，进行等待通知
            synchronized (coffee) {
                System.out.println(" customer begin order coffee");
                try {
                    System.out.println(Customer2.class.getName() +":wait coffee make");
                    coffee.wait();
                    System.out.println(Customer2.class.getName()+"wait coffe make finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Customer1());
        Thread thread2 = new Thread(new Customer2());
        Thread store = new Thread(new CoffeStoreThread());

        thread1.start();
        thread2.start();
        store.start();

    }

}
