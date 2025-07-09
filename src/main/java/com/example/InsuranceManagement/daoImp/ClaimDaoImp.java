package com.example.InsuranceManagement.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.InsuranceManagement.dao.ClaimDao;
import com.example.InsuranceManagement.model.Claim;
import com.example.InsuranceManagement.util.DatabaseConnection;

public class ClaimDaoImp implements ClaimDao {

	@Override
	public Claim getClaim(int claimId) {
		String query="SELECT * FROM claim WHERE claimId=?";
		Claim claim= new Claim();
		try(Connection con=DatabaseConnection.getConnection();) {
			PreparedStatement p=con.prepareStatement(query);
			p.setInt(1, claimId);
			ResultSet rs= p.executeQuery();
			if(rs.next()) {
				claim.setClaimId(rs.getInt("claimId"));
				claim.setPolicyId(rs.getInt("claimId"));
				claim.setClaimAmount(rs.getDouble("claimAmount"));
				claim.setClaimStatus(rs.getString("claimStatus"));
				claim.setSubmissionDate(rs.getDate("submissionDate"));
				claim.setSettlementDate(rs.getDate("settlementDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return claim;
	}

	@Override
	public List<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		List<Claim> claims=new ArrayList<>();
		String query="SELECT * FROM claim";
		try(Connection con=DatabaseConnection.getConnection();) {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return claims;
	}

	@Override
	public void createClaim(Claim claim) {
		// TODO Auto-generated method stub
		String query ="INSERT INTO claim(claimId, policyId, claimAmount, claimStatus, submissionDate, settlementDate) VALUES (?,?,?,?,?,?)";
		try (Connection con=DatabaseConnection.getConnection();){
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, claim.getClaimId());
			ps.setInt(2, claim.getPolicyId());
			ps.setDouble(3, claim.getClaimAmount());
			ps.setString(4, claim.getClaimStatus());
			ps.setDate(5, (Date) claim.getSubmissionDate());
			ps.setDate(6, (Date) claim.getSettlementDate());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateClaim(int claimId, String status) {
		// TODO Auto-generated method stub
		String query="UPDATE claim SET status=? WHERE claimId=?";
		try(Connection con = DatabaseConnection.getConnection();){
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(2, claimId);
			ps.setString(1, status);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
