package com.ratel.order.entity;

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
@Table(name = "t_order")
@Entity
@Data
public class Order implements Serializable {

	private static final long serialVersionUID = -3873714492987237627L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "order_status")
	private Integer orderStatus;

	@Column(name = "pay_status")
	private Integer payStatus;

	@Column(name = "pay_time")
	private Date payTime;

	@Column(name = "receiver_name")
	private String receiverName;

	@Column(name = "receiver_phone")
	private String receiverPhone;

	@Column(name = "receiver_address")
	private String receiverAddress;

	@Column(name = "receiver_post_code")
	private String receiverPostCode;

	@Column(name = "receive_time")
	private Date receiveTime;

	@Column(name = "remark")
	private String remark;

	@Column(name = "delete_status")
	private Integer deleteStatus;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;
}
