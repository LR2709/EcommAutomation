package com.qa.opencart.utilities;

public class StringUtil {
	
	public static String getRandonEmailId()
	{
		String email = "autoemail"+System.currentTimeMillis()+"@opencart.com";
		System.out.println(email);
		return email;
	}

}
