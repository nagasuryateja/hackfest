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
public class BankDetails {
	@DynamoDBAttribute
	private String accountNumber; 
	@DynamoDBAttribute
	private String bankName;
	 @DynamoDBAttribute
	private String branch;
	 @DynamoDBAttribute
	private String ifsc;

}
