package com.ratel.user.entity;

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
@Table(name = "t_user_address")
@Entity
@Data
public class UserAddress implements Serializable {
	private static final long serialVersionUID = 8264247176000923029L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long addressId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "province")
	private String province;

	@Column(name = "city")
	private String city;

	@Column(name = "district")
	private String district;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "post_code")
	private String postCode;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;
}
