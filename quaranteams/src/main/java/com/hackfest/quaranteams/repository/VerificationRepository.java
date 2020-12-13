package com.hackfest.quaranteams.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.hackfest.quaranteams.entity.BasicDetails;
import com.hackfest.quaranteams.entity.Person;

@Repository
public class VerificationRepository {
	
	@Autowired
    private DynamoDBMapper mapper;


    public BasicDetails addUserDetails(BasicDetails details) {
    	
    	BasicDetails findUser = mapper.load(BasicDetails.class, details.getAadhar());
    	if(findUser==null){
    		mapper.save(details);
    		return details;
    	}else{
    		details= new BasicDetails();
    		details.setError("User alreaded added in Database");
    	}
    	return details;
    }

    public BasicDetails fetchUserDetails(String aadhar,String pancard) {
    	BasicDetails fetchedDetails = mapper.load(BasicDetails.class, aadhar);
    	
    	if(fetchedDetails!=null){
    		if(fetchedDetails.getPancard().equalsIgnoreCase(pancard)){
    			return fetchedDetails;
    		}else{
    			fetchedDetails= new BasicDetails();
    			fetchedDetails.setError("given user aadhar number and pancard number doesn't match");
    		}
    	}else{
    		fetchedDetails= new BasicDetails();
    		fetchedDetails.setError("User not found with the given aadhar");
    	}
    	
    	return fetchedDetails;
    }
    
    public String editUserDetails(BasicDetails details) {
        mapper.save(details, buildExpression(details));
        return "record updated ...";
    }

    private DynamoDBSaveExpression buildExpression(BasicDetails details) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("aadhar", new ExpectedAttributeValue(new AttributeValue().withS(details.getAadhar())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }

   
}
