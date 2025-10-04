package com.it.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ApiResponse 
{
    private boolean status ;
    private String message;
    private String errormessage;
    private Object data;
    
	public ApiResponse(boolean status, String message, Object data) 
	{
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public ApiResponse(boolean status, String errormessage) {
		super();
		this.status = status;
		this.errormessage = errormessage;
	}
}
