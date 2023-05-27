package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO extends BasePagePO {
	private By userNameInput = By.id("username");
	private By passInput = By.id("password");
	private By btnLogin = By.cssSelector("button");
	private By invalidBox = By.id("invalid");

	public LoginFormPO(WebDriver driver) {
		super(driver);
		visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
	}

	public BasePagePO with(String username, String pwd) {
		type(userNameInput, username);
		type(passInput, pwd);
		click(btnLogin);
		if (getUrl().equals("https://bonigarcia.dev/selenium-webdriver-java/login-form.html"))
			return this;
		else
			return new LoginSuccessPO(driver);
	}

	public boolean InValidBoxIsPresent() {
		return isIn(invalidBox);
	}

}
