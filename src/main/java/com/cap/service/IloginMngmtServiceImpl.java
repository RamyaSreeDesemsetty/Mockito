package com.cap.service;

import com.cap.dao.ILoginDAO;

public class IloginMngmtServiceImpl implements ILoginMngmtService{
	private ILoginDAO loginDAO;

	public IloginMngmtServiceImpl(ILoginDAO loginDAO) {
		super();
		this.loginDAO = loginDAO;
	}

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if (username.equals(" ")||password.equals(" "))
		{
			throw new IllegalArgumentException("empty credentials");
			
			
		}
		int count = loginDAO.authenticate(username, password);
		if(count==0)
		return false;
		else
			return true;
	}

}
