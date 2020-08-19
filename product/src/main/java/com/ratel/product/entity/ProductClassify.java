package com.ratel.product.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Table(name = "t_product_classify")
@Entity
@Data
public class ProductClassify implements Serializable {
	private static final long serialVersionUID = 9175543188060231237L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_classify_id")
	private Long productClassifyId;

	@Column(name = "product_classify_name")
	private String productClassifyName;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;
}
