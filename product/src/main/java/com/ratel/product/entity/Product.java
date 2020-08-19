package com.ratel.product.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Table(name = "t_product")
@Entity
@Data
public class Product implements Serializable {
	private static final long serialVersionUID = -240311977954810914L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_classify_id")
	private Long productClassifyId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_price")
	private BigDecimal productPrice;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "product_address")
	private String productAddress;

	@Column(name = "delete_status")
	private Integer deleteStatus;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;

	@Column(name = "create_user_id")
	private Long createUserId;

	@Column(name = "create_user_name")
	private String createUserName;

	@Column(name = "update_user_id")
	private Long updateUserId;

	@Column(name = "update_user_name")
	private String updateUserName;
}
