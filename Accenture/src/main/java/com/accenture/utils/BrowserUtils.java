package com.accenture.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtils {

	public static WebDriver driver;

	public void launchBrowser(String browser) {
		switch (browser) {
		case "chrome":

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\naga.p.kakanuru\\Documents\\seleniumhq\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\naga.p.kakanuru\\Documents\\seleniumhq\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "ie":

			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\naga.p.kakanuru\\Documents\\seleniumhq\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.out.println("Browser name is invalid");
			break;
		}
	}

	public void getUrl(String URL) {
		driver.get(URL);
	}

}
