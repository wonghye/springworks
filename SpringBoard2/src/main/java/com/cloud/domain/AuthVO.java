package com.cloud.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthVO implements Serializable{

	
	private static final long serialVersionUID = 12L;
	
	private String userid;	//아이디
	private String auth;	//권한

	
}
