package kr.co.mumarket.vo;



import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCartVo {

	private int seq;
	private String uid;
	private int code;
	private String name;
	private String option;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String rdate;
	
	// 추가필드
	@Transient
	private String thumb1;
	@Transient
	private int cate1;
	@Transient
	private int cate2;
	
}