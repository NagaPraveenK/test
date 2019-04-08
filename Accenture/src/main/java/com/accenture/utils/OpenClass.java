package com.accenture.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenClass extends XLUtils {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naga.p.kakanuru\\Documents\\seleniumhq\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.co.in");
		String ss= getStringCellData("C:\\Users\\naga.p.kakanuru\\Desktop\\ARF.xlsm", "ARF", 3, 0);
		
		driver.findElement(By.name("q")).sendKeys(ss);
		driver.findElement(By.name("btnK")).click();
		

	}

}
