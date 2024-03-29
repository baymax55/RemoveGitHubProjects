package com.liyuncong.application.deletegithubproject.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * （基于selenium实现）登陆github,删除指定的项目
 * @author liyuncong
 *
 */
public class SeleniumDeleter extends Deleter {
	private WebDriver webDriver;

	@Override
	protected boolean init() {
//		System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
//		WebDriver webDriver = new InternetExplorerDriver();
//		System.setProperty("webdriver.firefox.bin",
//				"D:/program files (x86)/Mozilla Firefox/firefox.exe");
//		WebDriver webDriver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.bin",
		"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		System.setProperty("webdriver.chrome.driver",
				"driver/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get(loginPageUrl);
		WebElement loginField = webDriver.findElement(By.id("login_field"));
		loginField.sendKeys(userInfo.getLoginName());
		WebElement password = webDriver.findElement(By.id("password"));
		password.sendKeys(userInfo.getPassword());
		WebElement commit = webDriver.findElement(By.name("commit"));
		commit.click();
		return true;
	}

	@Override
	protected boolean deleteProject(String projectName) {
		String urlPrefix = "https://github.com/" + userInfo.getUserName() + "/";
		
		webDriver.get(urlPrefix + projectName + "/settings");

		String xPath="//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/summary";
		WebElement deleteButton = webDriver.findElement(By.xpath(xPath));

		deleteButton.click();
		
		List<WebElement> verifys = webDriver.findElements(By.name("verify"));
		verifys.get(verifys.size() - 1).sendKeys(projectName);

		String deleteConfirm="//*[@id=\"options_bucket\"]/div[8]/ul/li[4]/details/details-dialog/div[3]/form/button";
		WebElement deleteButtonConfirm = webDriver.findElement(By.xpath(deleteConfirm));

		deleteButtonConfirm.click();

//		WebElement confirmCommit = webDriver.findElements(By.xpath("//button[text()='I understand the consequences, delete this repository']")).get(1);
//		confirmCommit.click();
		return true;
	}

	@Override
	protected void destroy() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

}
