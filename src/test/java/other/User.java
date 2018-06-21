package other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 测试user,只有name，age
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/13
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User implements Comparable<User> {

  private String name;

  private Integer age;

  @Override
  public int compareTo(User o) {
    if (this.name.compareTo(o.name) == 0) {
      if(this.getAge()>o.getAge()){
        return -1;
      }else if(this.getAge()==o.getAge()){
        return 0;
      }else {
        return 1;
      }
    } else {
      return this.name.compareTo(o.name);
    }
  }
}
