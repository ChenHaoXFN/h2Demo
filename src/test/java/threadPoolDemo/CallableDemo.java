package threadPoolDemo;


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
 * Created at 2018/7/13
 */
public class CallableDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

  }

  public static class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
      return 1;
    }
  }
}
