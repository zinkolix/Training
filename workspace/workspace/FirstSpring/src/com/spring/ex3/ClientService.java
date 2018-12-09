package com.spring.ex3;

public class ClientService {

	private static ClientService service;
	
	public static ClientService getService() {
		System.out.println("Getting Service Object");
		if(service == null)
			service = new ClientService();
		return service;
	}
}

