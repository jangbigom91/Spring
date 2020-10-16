package kr.co.mumarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mm_products_order")
public class ProductsOrderVo {
	
	@Id
	private int seq;
	private String uid;
	private String products;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int applyPoint;
	private int delivery;
	private int total;
	private int payment;
	private int complete;
	private String orderer;
	private String hp;
	private String zip;
	private String addr1;
	private String addr2;
	private String rdate;
}
