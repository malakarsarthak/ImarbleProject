package com.it.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesResponseModel 
{
	private Integer salesId;
	private String clientName;
	private String branchName;
	private String salestype;
	private LocalDate salesDate;
	private Float billAmount;
	private String invoiceNumber;
	private boolean status;
}
