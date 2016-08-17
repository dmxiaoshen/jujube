package com.jujube.exception;

public class BusinessException extends RuntimeException{

	/** */
	private static final long serialVersionUID = -2608555813690622952L;
	
	public BusinessException(String message){
		super(message);
	}
	
	public BusinessException(String message,Throwable e){
		super(message,e);
	}
	
	public static void main(String[] args) {
		
		t();
	}
	
	public static void t(){
		int n = 9;
		try{
		n=n/0;
		}catch(Exception ex){
			throw new BusinessException("醋味",ex);
		}
	}

}
