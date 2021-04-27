package automatedTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class testClass3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//setting the driver executable
		 System.setProperty("webdriver.chrome.driver", "chromedriver90.exe");
		
		//Initiating chromedriver
		WebDriver driver=new ChromeDriver();

		
		

		//Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();

		//open browser with desried URL
		driver.get("https://jupiter.cloud.planittesting.com/");
		
		//Navigate to contact page
		driver.findElement(By.linkText("Contact")).click();
		
		//click submit
		driver.findElement(By.linkText("Submit")).click();
		
		
		populateFeilds(driver);
		
		validateErrors(driver);
		
		}
	
	public static void populateFeilds(WebDriver driver) {
		//Populate forename invalid
		//Could not find an invalid text entry for name
		
		
		//Populate email
		WebElement emailText = driver.findElement(By.id("email"));
		emailText.clear();
		emailText.sendKeys("Alext");
		
		//Populate email
		//Could not find an invalid text entry for email
	}
	
	public static void validateErrors(WebDriver driver) {
		 
		//Validate email error
		try {
			//Expected string
			String expEmail = "Please enter a valid email";
			
			//Actual error message
			WebElement email = driver.findElement(By.id("email-err"));
			String actEmail = email.getText();
			System.out.println("Error message is: "+ actEmail);
			
			//Assert expected error message is showing 
			System.out.println("Expected email error is showing: " + actEmail.contains(expEmail));
		}catch (Exception e){
			System.out.println("Email error is not displayed");
		}
		
			
	}

}


