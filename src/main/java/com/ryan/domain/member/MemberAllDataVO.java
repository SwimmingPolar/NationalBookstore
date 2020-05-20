package com.ryan.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberAllDataVO {
	
	private int libBookCount;
	private int PostCount;
	private int followCount;
	private int realBookCount;
	
}
