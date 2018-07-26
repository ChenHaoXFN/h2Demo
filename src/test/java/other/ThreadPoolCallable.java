package other;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolCallable {
  public static void main(String[] args) {

    ExecutorService threadPool = Executors.newFixedThreadPool(1);
    List<Runnable> runnables = threadPool.shutdownNow();

    RunMethod r = new RunMethod();
    new Thread(() -> {
      for (int i = 1; i < 11; i++) {

        r.ThreadOne(i);
      }
    }
    ).start();
    for (int i = 1; i < 11; i++) {
      r.MainThread(i);
    }
  }

  public static class RunMethod {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private boolean flag = true;

    public void ThreadOne(int numA) {
      lock.lock();
      try {
        while (flag) {
          try {

            condition.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        for (int i = 1; i < 11; i++) {
          System.out.println("线程一跑到第: " + i + "次，总共循环" + numA + "次");
        }
        flag = false;
        condition.signal();
      } finally {
        lock.unlock();
      }
    }

    public void MainThread(int numA) {
      lock.lock();
      try {
        while (!flag) {
          try {
            condition.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        for (int i = 1; i < 50; i++) {
          System.out.println("线程二跑到第: " + i + "次，总共循环" + numA + "次");
        }
        flag = true;
        condition.signal();
      } finally {
        lock.unlock();
      }
    }
  }

}
