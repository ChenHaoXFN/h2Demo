package ddd;

import org.springframework.beans.BeanUtils;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/18
 */
public class Copy {

  public static void main(String[] args) {
    Person person = new Person();
    BeanUtils.copyProperties(null,person);
  }

}
