package com.accenture.Pages;

import java.awt.Frame;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import com.accenture.utils.CommonFunctions;
import com.accenture.utils.XLUtils;

public class LoginPage extends CommonFunctions {
	
	XLUtils xl=new XLUtils();
	
	public void login(String username) throws Exception {
		launchBrowser("chrome");
		getUrl("https://ts.accenture.com/sites/ACN_Nationwide_Sharepoint/Lists/NBS%20Vacation%20Tracking/AllItems.aspx");
		//click("id", "otherTileText");
		sendKeys("id", "i0116", username);
		click("id", "idSIButton9");
		sendKeys("name", "Password", "Sweety@3516");
		//Thread.sleep(30000);
		click("id", "submitButton");
		//click("xpath", "//*[@id='vipOoblink']");
		System.out.println(getText("xpath", "//*[contains(text(), 'Confirm Your Identity')]"));
		if(getText("xpath", "//*[contains(text(), 'Confirm Your Identity')]").equals("Confirm Your Identity"))
		{
			Thread.sleep(20000);
			click("id", "vipSubmitOTP");
		}
		System.out.println(getText("xpath", "//div[@class='row text-title']"));
		if(getText("xpath", "//div[@class='row text-title']").equals("Stay signed in?"))
		{
			click("id", "KmsiCheckboxField");
			click("id", "idSIButton9");
		}
		}
	
	public void addItem() throws IOException, Exception
	{
		click("xpath", "//span[contains(text(), 'new item')]");
		Thread.sleep(5000);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id, 'DlgFrame')]")));
		
		
		if(getText("xpath", "//span[@class='ae_hpYcgdpwAEkeCvZc_0']").equals("Absence Request Form"))
		{
			
			int rc=xl.getRowCount("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1");
			for(int i=1; i<=rc;i++)
			{
				String ResourceName =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 0);
				String AbsenceReason  =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 1);
				String WorkingDays =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 2);
				String StartDay =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 3);
				String EndDay =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 4);
				String Comments =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 5);
				String LineManagerName =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 6);
				String Project =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 7);
				String Location =xl.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Accenture\\src\\Book1.xlsx", "Sheet1", i, 8);
			
			
			
			sendKeys("xpath", "//tbody[@class=\"at_hpYcgdpwAEkeCvZc_0\"]/tr/td/div[2]/table/tbody/tr[2]/td[2]//table/tbody/tr/td/div", ResourceName);//Resource Name
			System.out.println(AbsenceReason);
			click("xpath", "//div[@class='at_hpYcgdpwAEkeCvZc_0']/table/tbody/tr[3]/td[2]/span/select");
			Thread.sleep(1000);
			select("xpath", "//div[@class='at_hpYcgdpwAEkeCvZc_0']/table/tbody/tr[3]/td[2]/span/select", "value", AbsenceReason);
			//sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0_V1_I1_D3", AbsenceReason);//Absence Reason? 
			sendKeys("xpath", "//td[@class='e_hpYcgdpwAEkeCvZc_0 j_hpYcgdpwAEkeCvZc_0 ag_hpYcgdpwAEkeCvZc_0']/span/input", WorkingDays); //Absence duration 
			sendKeys("xpath", "//div[@class='am_hpYcgdpwAEkeCvZc_0']/span/input", StartDay);//Start date
			sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0_V1_I1_T7", EndDay);//End date
			sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0_V1_I1_T9", Comments);//Comments
			sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0__customcontrol1_upLevelDiv", LineManagerName);//Line Manager Name
			//sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0_V1_I1_D11", "");//Approved?
			//sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0_V1_I1_T12", "");//Line Manager comments
			sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0_V1_I1_D13", Project);//Project
			sendKeys("id", "ctl00_ctl39_g_d9a09d87_4ae3_48cb_8948_64665c095f2a_FormControl0__customcontrol0_upLevelDiv", Location);//Location
			
			
			}
			
			
			
			
			
			
			
			
			
			
		}
	}
		
	

}
