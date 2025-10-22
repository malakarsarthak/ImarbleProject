package com.it.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDispatchRequestModel 
{
	@NotNull(message = "Dispatch Date Not Null")
	@JsonFormat(pattern = "yyyy-MM-dd") 
	private LocalDate dispatchDate;
	
	@NotNull(message = "Dispatcher Id Not Null")
	private Integer dispatcher;
	
	@NotNull(message = "Sales Id Not Null")
	private Integer sales;
}
