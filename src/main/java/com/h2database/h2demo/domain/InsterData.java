package com.h2database.h2demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * TODO
 *
 * @author <a href="mailto:chenhao2010h@163.com">chenhao</a>
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2018/7/13
 */
@Entity
@Data
@Table
public class InsterData {

  @Id //主键z
  private Integer id;

}
