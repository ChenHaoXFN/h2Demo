package threadPoolDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/26
 */
public class TicketsDemo {

  public static void main(String[] args) {
    Runnable tick = new Tickets();
    Thread t1 = new Thread(tick, "窗口1");
    Thread t2 = new Thread(tick, "窗口2");
    Thread t3 = new Thread(tick, "窗口3");
    t1.start();
    t2.start();
    t3.start();
  }

  public static class Tickets implements Runnable {

    // 总共有100张票
    private Integer tickets = 100;
    //  创建Lock实现类对象
    private Lock lock = new ReentrantLock();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();


    @Override
    public void run() {
      while (true) {
        // 获得锁
        rwl.writeLock().lock();
        if (tickets > 0) {
          try {
            // 模拟服务器卡顿，增加CPU切换执行概率.
            Thread.sleep(100);
            // 输出那个窗口买到第几张票
            System.out.println(Thread.currentThread().getName() + " 购买到 " + tickets--);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }finally {
            // 释放锁
            rwl.writeLock().unlock();
          }

        }
      }
    }
  }
}
