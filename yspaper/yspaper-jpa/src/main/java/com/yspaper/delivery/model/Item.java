package com.yspaper.delivery.model;

import com.yspaper.core.MyObject;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
@Table(name="tb_item")

public class Item extends MyObject implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	private Long orderNo;
	private Integer itemNo;
	private String product;
	private BigDecimal quantity;
	private static final long serialVersionUID = 1L;

	public Item() {
		super();
	}   
	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}   
	public Long getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}   
	public Integer getItemNo() {
		return this.itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}   
	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}   
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
   
}
