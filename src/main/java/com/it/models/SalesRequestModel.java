package com.it.models;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesRequestModel 
{
	@NotNull(message = "Client Id Not Null")
	private Integer  clientid;

	@NotNull(message = "Sales Type Not Null")
	@NotEmpty(message= "Sales Type Not Empty")
	private String salestype;

	@NotNull(message = "Sales Date Not Null")
	@JsonFormat(pattern = "yyyy-MM-dd") 
	private LocalDate salesDate;

	@NotNull(message = "Bill Amount Not Null")
	private Float billAmount;

	@NotNull(message = "Branch Id Not Null")
	private Integer branchid;

	@NotNull(message = "Invoice Number Not Null")
	@NotEmpty(message= "Invoice Number Empty")
	private String invoiceNumber;

	@NotNull(message = "Sales status Not Null")
	private boolean status;
}
