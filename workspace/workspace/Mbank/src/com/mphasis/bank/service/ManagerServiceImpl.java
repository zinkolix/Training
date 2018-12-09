/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.service;

public class ManagerServiceImpl implements ManagerService {

	@Override
	public void openAccount() {
		System.out.println("This is the method for opening an account");

	}

	@Override
	public void closeAccount() {
		System.out.println("This is closing account method");

	}

	@Override
	public void reports() {
		System.out.println("This is reports method");

	}

	@Override
	public void addStaff() {
		System.out.println("This is add staff method");

	}

	@Override
	public void removeStaff() {
		System.out.println("This is remove staff method");

	}

}
