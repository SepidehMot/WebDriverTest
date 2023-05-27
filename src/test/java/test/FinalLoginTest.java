package test;

import org.junit.jupiter.api.Test;
import POs.LoginFormPO;
import POs.LoginSuccessPO;
import static org.junit.jupiter.api.Assertions.*;

public class FinalLoginTest extends DriverLifeCycleSetting {

	private LoginFormPO loginForm;
	private LoginSuccessPO loginSuccess;

	@Test
	public void testLoginOK() throws InterruptedException {
		loginForm = new LoginFormPO(driver);
		loginSuccess = (LoginSuccessPO) loginForm.with("user", "user");
		assertTrue(loginSuccess.SuccessBoxIsPresent());
	}

	@Test
	public void testLoginNoOK() throws InterruptedException {
		loginForm = new LoginFormPO(driver);
		loginForm.with("user", "error");
		assertTrue(loginForm.InValidBoxIsPresent());
	}
}
