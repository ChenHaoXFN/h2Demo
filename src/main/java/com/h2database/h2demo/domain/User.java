package com.h2database.h2demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * User实体类.
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/6/21
 */
@Entity
@Data
@Table
public class User {
  @Id //主键
  private Integer id;
  private Integer age;
  private String name;
  private String address;
  private String city;
}
