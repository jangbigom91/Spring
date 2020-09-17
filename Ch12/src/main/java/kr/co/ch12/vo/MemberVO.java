package kr.co.ch12.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="MEMBER")
public class MemberVO {
	
	@Id
	private String uid;
	private String name;
	private String hp;
	private String pos;
	private int dep;
	private String rdate;
}
