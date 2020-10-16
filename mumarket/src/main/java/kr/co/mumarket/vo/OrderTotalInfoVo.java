package kr.co.mumarket.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderTotalInfoVo {
	
	private int count;
	private int price;
	private int sale;
	private int delivery;
	private int point;
	private int total;
}
