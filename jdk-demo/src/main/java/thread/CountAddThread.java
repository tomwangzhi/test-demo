package thread;

/**
 * 1. 1000 个线程对 共享内存的静态变量 count执行add操作，最终的结果是否会等于 1000？
 * 最终的结果是 小于等于1000
 * 因为  count ++  用  javap -c CountAddThread.class 看指令
 * 可知该操作是分为几步进行的。
 * 而每个线程的执行都只能在自己的本地内存中去执行方法。
 * 1. 需要将 堆区的数据拷贝一份到自己的本地内存  获取到count不是最新的。就存在脏读。
 * 2. 将改数据加1
 * 3. 将更新的数据刷新到共享内存（堆区中）
 *
 * 1000个线程执行完计数后输出：985 977
 */
public class CountAddThread {

    private static int count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    // 线程休眠 2毫秒，让cpu存在调度的切换。  切换共有两种方式：1. 抢占式 2.共享式
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1000个线程执行完计数后输出："+count);
    }
}
