package com.example.InsuranceManagement.dao;

import java.util.List;

import com.example.InsuranceManagement.model.Claim;

public interface ClaimDao {
	
	Claim getClaim(int claimId);
	List<Claim> getAllClaims();
	void createClaim(Claim claim); 
	void updateClaim(int claimId, String status);

}
