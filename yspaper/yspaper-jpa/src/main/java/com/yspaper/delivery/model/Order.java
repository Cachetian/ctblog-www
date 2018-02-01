package com.yspaper.delivery.model;

import com.yspaper.core.MyObject;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name="tb_order")

public class Order extends MyObject implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private String serialNumber;
	private String customer;
	private Long documentDate;
	private Integer type;
	private BigDecimal prise;
	private Integer count;
	private BigDecimal totalAmount;
	private static final long serialVersionUID = 1L;

	public Order() {
		super();
	}   
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}   
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}   
	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}   
	public Long getDocumentDate() {
		return this.documentDate;
	}

	public void setDocumentDate(Long documentDate) {
		this.documentDate = documentDate;
	}   
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}   
	public BigDecimal getPrise() {
		return this.prise;
	}

	public void setPrise(BigDecimal prise) {
		this.prise = prise;
	}   
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}   
	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
   
}
