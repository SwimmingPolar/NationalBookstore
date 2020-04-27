package com.ryan.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.ryan.domain.EBookVO;

public interface SearchMapper {
	public ArrayList<EBookVO> typeWriter(String [] w);
	
	public ArrayList<EBookVO> typeBookname(String [] bn);
}
