package com.it.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DispatchItemResponseModel 
{
	private Integer dispatchItemId;
	private Integer dispatchid;
	private Integer salesid;
	private Integer quantity;
}
