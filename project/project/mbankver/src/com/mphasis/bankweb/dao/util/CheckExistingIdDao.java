package com.mphasis.bankweb.dao.util;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
public interface CheckExistingIdDao {
	
	public boolean checkExistingEmpId(String empId);
	public boolean checkExistingCustId(String custId);
	public boolean checkExistingDepositAccntId(String accntId);
	public boolean checkExistingLoanAccntId(String accntId);
	

}
