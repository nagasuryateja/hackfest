package com.hackfest.quaranteams.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBDocument
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDetails {
	@DynamoDBAttribute
	private String insurer; 
	@DynamoDBAttribute
	private String branchCode;
	 @DynamoDBAttribute
	private String policyNumber;

}
