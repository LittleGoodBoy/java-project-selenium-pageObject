package com.yanfuchang.selenium.pageobject.business;

import org.openqa.selenium.WebDriver;

import com.yanfuchang.selenium.pageobject.page.BaiduPage;
/**
 * 页面对应的功能逻辑类
 */
public class BaiduBusiness {
	
	private WebDriver driver;
	
	public BaiduBusiness(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchForCondition(String condition) {
		BaiduPage page = new BaiduPage();
		//1、点击搜索框,目的：将光标聚焦到搜索框
		page.click_Search_Bar(driver);
		//2、输入查询内容到搜索框
		page.input_Search_Box(driver, condition);
		//3、点击查询按钮
		page.click_Search_Button(driver);
	}
}
