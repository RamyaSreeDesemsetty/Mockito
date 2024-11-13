package com.capgemini.in.MockitoDemoFive;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cap.dao.ILoginDAO;
import com.cap.service.ILoginMngmtService;
import com.cap.service.IloginMngmtServiceImpl;



/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
	private static ILoginMngmtService loginService;
	private static ILoginDAO  loginDAOMock;
	@BeforeAll
	public static void setupOnce()
	{
		loginDAOMock = Mockito.mock(ILoginDAO.class);
		loginService = new IloginMngmtServiceImpl(loginDAOMock);
	}
	@AfterAll	
    public static void clearOnce()
{
	loginDAOMock = null;
	loginService = null;
}
	@Test
   public void testLoginWithValidCredentials()
   {
		//creating stub
	   Mockito.when(loginDAOMock.authenticate("raja","rani")).thenReturn(1);
	   assertTrue(loginService.login("raja","rani"));
   }
	
}
