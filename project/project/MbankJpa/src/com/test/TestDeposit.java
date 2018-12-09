package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mphasis.bankweb.dao.EmployeeDao;
import com.mphasis.bankweb.dao.EmployeeDaoImpl;
import com.mphasis.bankweb.entity.DepositCustomer;
import com.mphasis.bankweb.service.DepositCustomerService;
import com.mphasis.bankweb.service.EmployeeService;
import com.mphasis.bankweb.util.BalanceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/appctx.xml")
public class TestDeposit {

	@Autowired
	private ApplicationContext appCtx;
	
	@Autowired
	@Qualifier("daoCust")
	private EmployeeDao dao;

	@Test
	public void testDeposit() {
		DepositCustomerService service = (DepositCustomerService) appCtx.getBean("depositCustomerServiceImpl");
		service.depositAmount("SB44397", 2000);

	}
	
	@Test
	public void testWithdraw() throws BalanceException{
		DepositCustomerService service = (DepositCustomerService) appCtx.getBean("depositCustomerServiceImpl");
		service.withdrawAmount("SB44397", 2000);
	}
	
	@Test
	public void testOpenAccount() {
		EmployeeService service = (EmployeeService)appCtx.getBean("depositEmployeeServiceImpl");
		DepositCustomer cust = new DepositCustomer();
		service.openAccount(cust);
	}
	
	@Test
	public void testCloseAccount(){
		EmployeeService service = (EmployeeService)appCtx.getBean("depositEmployeeServiceImpl");
		service.closeAccount("MLA12457");
	}
	
	@Test
	public void testCheckingPan(){
		
		dao.checkExistingPan("ABCD1114");
	}
	
	@Test
	public void testReports(){
		EmployeeService service = (EmployeeService)appCtx.getBean("depositEmployeeServiceImpl");
		service.reports(12345);
	}

	
}
