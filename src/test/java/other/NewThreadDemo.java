package other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/17
 */
public class NewThreadDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 创建callable对象
    MyCallable myCallable = new MyCallable();
    FutureTask<Integer> result = new FutureTask<>(myCallable);
    Thread thread = new Thread(result);
    thread.start();
    // 取得返回值
    Integer num = result.get();
    System.out.println(num);
  }

  public static class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
      System.out.println("实现Callable，重写call方法实现线程");
      return 1;
    }
  }
}
