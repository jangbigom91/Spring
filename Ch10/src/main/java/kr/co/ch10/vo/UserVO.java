package kr.co.ch10.vo;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserVO {
	@NonNull private String uid;
	@NonNull private String name;
	@NonNull private int age;
	@NonNull private String rdate;
}
