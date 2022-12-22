package org.stepdefinition;

import org.baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlipkartLogin extends BaseClass{

	@Given("To launch the chrome browser and maximize the window")
	public void to_launch_the_chrome_browser_and_maximize_the_window() {
		launchBrowser();
		windowMaximize();
	}

	@When("To launch the url of flipkart application")
	public void to_launch_the_url_of_flipkart_application() {
		launchUrl("https://www.flipkart.com/");
	}

	@When("To click the login button in homepage")
	public void to_click_the_login_button_in_homepage() {
		WebElement loginHomeclick = driver.findElement(By.xpath("//a[text()='Login']"));
		loginHomeclick.click();
	}

	@When("To pass valid number in number field")
	public void to_pass_valid_number_in_number_field() {
		WebElement loginnum = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		loginnum.sendKeys("8940990534");
	}

	@When("To pass valid password in password field")
	public void to_pass_valid_password_in_password_field() {
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		passText("prakrises", password);
	
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		WebElement loginClick = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		loginClick.click();
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowser();
	}

}
