package com.ryan.domain.book;

public class BookMarkVO {
	private int bookmarkNum;
	private String memberEmail;
	private int bookNum;
	private int pageStatus;
	public int getBookmarkNum() {
		return bookmarkNum;
	}
	public void setBookmarkNum(int bookmarkNum) {
		this.bookmarkNum = bookmarkNum;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getPageStatus() {
		return pageStatus;
	}
	public void setPageStatus(int pageStatus) {
		this.pageStatus = pageStatus;
	}
}
