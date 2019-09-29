package com.test2;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class Demo {
	
	@Test(priority = 1,enabled=false)
	public void a()
	{
		System.out.println("Username is " );
		System.out.println("Password is ");
	}
	
	@Test(priority = 1,enabled=true)
	public void b()
	{
		System.out.println("Test 'b' Passed!");
	}
	
	@Test(priority = 1,enabled=true)
	public void c()
	{
		SoftAssert softassert=new SoftAssert();
		a();
		b();

		String d="adk";
		String e="aek";
		softassert.assertEquals(d,e,"Fails");
		System.out.println(d);
		softassert.assertAll();
}
}