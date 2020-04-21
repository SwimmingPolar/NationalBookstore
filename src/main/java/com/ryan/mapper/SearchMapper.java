package com.ryan.mapper;

import java.util.HashMap;

import com.ryan.domain.EBookVO;

public interface SearchMapper {
	public EBookVO searchBook(HashMap<String,Object> map);
}
