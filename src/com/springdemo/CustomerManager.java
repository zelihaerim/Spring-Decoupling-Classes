package com.springdemo;

public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	
	
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal=customerDal;
	}
	/* Sektorun yuzde 99 u constructor injection kullanir. */

	public void add() {
		customerDal.add();
	}
	
}
