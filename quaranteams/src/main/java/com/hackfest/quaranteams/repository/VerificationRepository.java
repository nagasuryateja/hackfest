package com.hackfest.quaranteams.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.hackfest.quaranteams.entity.BasicDetails;

@Repository
public class VerificationRepository {
	
	@Autowired
    private DynamoDBMapper mapper;


    public BasicDetails addUserDetails(BasicDetails details) {
    	
    	BasicDetails findUser = mapper.load(BasicDetails.class, details.getAadhar());
    	if(findUser==null){
    		mapper.save(details);
    		return details;
    	}
    	return null;
    }

    public BasicDetails fetchUserDetails(String aadhar) {
        return mapper.load(BasicDetails.class, aadhar);
    }

   
}
