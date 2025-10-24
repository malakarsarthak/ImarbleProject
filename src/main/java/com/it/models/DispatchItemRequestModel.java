package com.it.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DispatchItemRequestModel {
    
    @NotNull(message = "Dispatch Id Not Null")
    private Integer dispatchid;

    @NotNull(message = "Sales Id Not Null")
    private Integer salesid;

    @NotNull(message = "Quantity Not Null")
    @NotEmpty(message = "Quantity Not Empty")
    private Integer quantity;
}
