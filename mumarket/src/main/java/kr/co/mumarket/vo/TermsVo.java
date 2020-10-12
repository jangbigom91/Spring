package kr.co.mumarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mm_terms")
public class TermsVo {
	
	@Id
	private int seq;
	private String terms;
	private String privacy;
	private String finance;
	private String reception;
}