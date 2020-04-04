package com.yanfuchang.selenium.pageobject.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 浏览器驱动类
 */
public class BrowserUtil {
	
	public static WebDriver driver;

	// 启动谷歌浏览器
	public static WebDriver setupChrome(String test_url) {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(test_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	// 启动火狐浏览器(需要最新geckodriver.exe,放到firfox的根目录)
	public static WebDriver setupFirfox(String test_url) {
		 System.setProperty("webdriver.firefox.marionette",".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(test_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	// 启动IE浏览器
	public static WebDriver setupIE(String test_url) {
		System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(dc);
		driver.get(test_url);
		return driver;
	}

	// 关闭浏览器
	public static void teardownBrowser() {
		driver.close();
	}
}
