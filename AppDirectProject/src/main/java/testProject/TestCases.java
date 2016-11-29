package testProject;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import testProject.Keywords;


public class TestCases extends Keywords {
	
	@Before 
	
	public void openBrowser(){
		launchBrowser(url);
		
	}
	@Test
	public  void TC_1() {
		try {
			System.out.println("TC 1 Execution Start");
			String emailId = generateEmailID();
			assertEquals(HomePageTitle, getTitle());
			click(logIn);
			assertEquals(LogInPageTitle, getTitle());
			click(signUp);
			filltextbox(emailTextBox,emailId);
			click(signUpBtn);
			assertEquals(headerMsg,getText(headMsg));
			assertEquals(confirmationMsg1+emailId+".",getText(confMsg1));
			assertEquals(confirmationMsg2,getText(confMsg2));
			System.out.println("TC 1 Execution Pass");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TC 1 Execution Failed");
		}
					
	}
	@Test
	public  void TC_2() {
		try {
			System.out.println("TC 2 Execution Start");

			assertEquals(HomePageTitle, getTitle());
			click(logIn);
			assertEquals(LogInPageTitle, getTitle());
			click(signUp);
			filltextbox(emailTextBox,dupEmailId);
			click(signUpBtn);
			assertEquals(dupEmailErrMsg,getText(dupEmailErr));	
			System.out.println("TC 2 Execution Pass");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TC 2 Execution Failed");
		}
					
	}
	@Test
	public  void TC_3() {
		try {
			System.out.println("TC 3 Execution Start");

			assertEquals(HomePageTitle, getTitle());
			click(logIn);
			assertEquals(LogInPageTitle, getTitle());
			click(signUp);
			filltextbox(emailTextBox,invalidEmailId);
			click(signUpBtn);
			
			assertEquals(invalidEmailId+invalidErrMsg,getText(dupEmailErr));
			
			System.out.println("TC 3 Execution Pass");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TC 3 Execution Failed");
			}
		}

@After
public void destroy(){
	quitDriver();
}

}
