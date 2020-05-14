package com.ryan.domain.main;

import java.util.ArrayList;

import lombok.Data;

@Data
public class KeywordAutoCompletionVO {
	
	private int bookNum;
	private String bookTitle;
	private String bookWriter;
	
	private ArrayList<String> hashTagList;
	
}
