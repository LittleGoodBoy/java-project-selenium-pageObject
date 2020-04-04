package com.yanfuchang.selenium.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.yanfuchang.selenium.pageobject.path.BaiduPath;

/**
 *	百度首页
 */
public class BaiduPage extends BaiduPath{
	
	// 点击搜索栏
    public void click_Search_Bar(WebDriver driver){
        driver.findElement(By.id(search_bar_id)).click();
    }        
    // 搜索框输入
    public void input_Search_Box(WebDriver driver,String key_word){        
        driver.findElement(By.id(search_box_id)).clear();
        driver.findElement(By.id(search_box_id)).sendKeys(key_word);
    }    
    //点击搜索按钮(百度一下)
    public void click_Search_Button(WebDriver driver){            
        driver.findElement(By.name(search_button_id)).click();
    }
}
