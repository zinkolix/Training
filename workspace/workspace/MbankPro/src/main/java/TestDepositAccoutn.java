import java.util.Date;

import org.junit.Test;

import com.mphasis.bank.dao.EmployeeDao;
import com.mphasis.bank.dao.EmployeeDaoImpl;
import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.DepositCustomer;
import com.mphasis.bank.entity.DepositTransaction;
import com.mphasis.bank.entity.LoanCustomer;
import com.mphasis.bank.service.DepositCustomerService;
import com.mphasis.bank.service.DepositCustomerServiceImpl;
import com.mphasis.bank.service.DepositEmployeeServiceImpl;
import com.mphasis.bank.service.EmployeeService;
import com.mphasis.bank.service.LoanCustomerService;
import com.mphasis.bank.service.LoanCustomerServiceImpl;
import com.mphasis.bank.service.LoanEmployeeServiceImpl;
import com.mphasis.bank.service.ManagerService;
import com.mphasis.bank.service.ManagerServiceImpl;
import com.mphasis.bank.util.AccountOpenProtocolException;
import com.mphasis.bank.util.BalanceException;

import static org.junit.Assert.*;
public class TestDepositAccoutn {

	@Test
	public void testOpenAccount()
	{
		DepositCustomer cust = new DepositCustomer();
		
		EmployeeService es = new DepositEmployeeServiceImpl();
//		DepositCustomer cust1 = (DepositCustomer)cust;
	
//		cust1.setCustId("MLA12347");				
	
		try {
			es.openAccount(cust);
		} catch (AccountOpenProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCloseAccount() throws AccountOpenProtocolException{
		EmployeeService es = new DepositEmployeeServiceImpl();
		EmployeeDao ed = new EmployeeDaoImpl();
//		assertTrue(ed.checkExistingPan("ABCD9873"));
		es.closeAccount("MLA12567");
	}
	
	@Test
	public void testDeposit() throws BalanceException{
		DepositCustomerService customerService = new DepositCustomerServiceImpl();
		customerService.depositAmount("SB44397", 2000);
	}
	
	@Test
	public void testWithdraw() throws BalanceException{
		DepositCustomerService customerService = new DepositCustomerServiceImpl();
		customerService.depositAmount("SB44397", 2000);
	}
	
	@Test
	public void testOpenLoanAccount() throws AccountOpenProtocolException{
		LoanCustomer cust = new LoanCustomer();
		EmployeeService es = new LoanEmployeeServiceImpl();
		es.openAccount(cust);
	}
	
	@Test
	public void testCloseLoanAccount() throws AccountOpenProtocolException{
		LoanCustomer cust = new LoanCustomer();
		EmployeeService es = new LoanEmployeeServiceImpl();
		es.closeAccount("MLA14879");
	}
	
	@Test
	public void testPrintSummary(){
		LoanCustomer cust =new LoanCustomer();
		LoanCustomerService es = new LoanCustomerServiceImpl();
		es.printStatement("LN13341");
		
	}
	
	
	@Test
	public void testManagerAddStaff(){
		ManagerService service = new ManagerServiceImpl();
		service.addStaff("dept02");
	}

}
