package com.travel.Agent.dto;

public class MessageDto {

	public MessageDto(Long userid, String commentcontent) {
		
		this.userid = userid;
		this.commentcontent = commentcontent;
	}

	public MessageDto() {
		
	}
	
	private Long userid;
	
	private String commentcontent;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	
	
}
