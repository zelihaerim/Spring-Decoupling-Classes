package com.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("database") // bean tanimini annotation ile yapimi
public class MySqlCustomerDal implements ICustomerDal {
	@Value("${database.connectionString}")
	String connectionString;
	
	public String getConnectionString() {
		return connectionString;
	}

	@Override
	public void add() {
		System.out.println("Connection string:"+this.connectionString);
		System.out.println("My Sql veritabanina eklendi");
		
	}
	
}
