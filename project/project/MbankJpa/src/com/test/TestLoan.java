package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mphasis.bankweb.dao.EmployeeDao;
import com.mphasis.bankweb.entity.LoanCustomer;
import com.mphasis.bankweb.service.EmployeeService;
import com.mphasis.bankweb.service.LoanCustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/appctx.xml")
public class TestLoan {
	
	@Autowired
	private ApplicationContext appCtx;
	
	@Autowired
	@Qualifier("daoCust")
	private EmployeeDao dao;
	
	@Autowired
	@Qualifier("loan")
	EmployeeService service;
	
	@Test
	public void testPartPayment(){
		LoanCustomerService service = (LoanCustomerService) appCtx.getBean("loanCustomerServiceImpl");
		service.partPayment("LN13691", 2000);
	}
	
	@Test
	public void testOpenLoanAccount(){
//		EmployeeService service = (EmployeeService)appCtx.getBean("loanEmployeeServiceImpl");
		LoanCustomer cust = new LoanCustomer();
		service.openAccount(cust);
	}
	
	@Test
	public void testForeClosure(){
		LoanCustomerService custService = (LoanCustomerService) appCtx.getBean("loanCustomerServiceImpl");
		custService.foreClosure("LN13691", 2000);
	}
	
	@Test
	public void closeLoanAccount(){
		service.closeAccount("MLA13879");
	}

}
