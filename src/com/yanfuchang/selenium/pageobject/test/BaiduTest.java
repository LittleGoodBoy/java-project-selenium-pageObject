package com.yanfuchang.selenium.pageobject.test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.yanfuchang.selenium.pageobject.business.BaiduBusiness;
import com.yanfuchang.selenium.pageobject.util.BrowserUtil;

public class BaiduTest {
	WebDriver driver;
	BaiduBusiness baidu = new BaiduBusiness(this.driver);
	
	/**
	 * 整个测试套件执行测试之前初始化浏览器驱动
	 */
	@BeforeSuite
	public void beforeSuite() {
		driver = BrowserUtil.setupChrome("http://www.baidu.com/");
	}
	
	@Test
	public void test_Search() {
		//1、定义要搜索的内容
		String condition = "PageObject模式详解";
		//2、调用百度查询业务
		baidu.searchForCondition(condition);
		//3、记录日志到报告
		Reporter.log("查询内容:" + condition);
		//4、断言
		try {
			String title = driver.getTitle();
			System.out.println(title);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 整个测试套件执行测试之后关闭浏览器
	 */
	@AfterSuite
	public void afterSuite() {
		BrowserUtil.teardownBrowser();
	}
}
