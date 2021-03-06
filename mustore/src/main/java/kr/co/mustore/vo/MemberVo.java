package kr.co.mustore.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mu_member")
public class MemberVo {
	
	@Id
	private String uid;
	private String pass;
	private String name;
	private int gender;
	private String hp;
	private String email;
	private String zip;
	private String addr1;
	private String addr2;
	private String ip;
	private String leaveDate;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
}
