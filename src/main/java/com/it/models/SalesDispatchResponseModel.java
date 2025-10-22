package com.it.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDispatchResponseModel 
{
	  private Integer dispatchId;
	  private LocalDate dispatchDate;
	  private Integer dispatcher;
	  private Integer sales;
}
