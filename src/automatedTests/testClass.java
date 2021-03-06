package automatedTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class testClass {
	
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
		
		validateErrors(driver);
		
		populateFeilds(driver);
		
		validateErrors(driver);
		
		}
	
	public static void populateFeilds(WebDriver driver) {
		//Populate forename
		WebElement forenameText = driver.findElement(By.id("forename"));
		forenameText.clear();
		forenameText.sendKeys("Alex");
		
		//Populate email
		WebElement emailText = driver.findElement(By.id("email"));
		emailText.clear();
		emailText.sendKeys("Alext@gmail.com");
		
		//Populate email
		WebElement messageText = driver.findElement(By.id("message"));
		messageText.clear();
		messageText.sendKeys("This is a message");
	}
	
	public static void validateErrors(WebDriver driver) {
		 
		//Validate error message
		
		//Expected string
		String exp = "but we won't get it unless you complete the form correctly";
		
		//Actual error message
		WebElement m = driver.findElement(By.className("alert"));
		String act = m.getText();
		System.out.println("Error message is: "+ act);
		
		//Assert expected error message is showing 
		System.out.println("Expected error is showing: " + act.contains(exp));
		
		//Validate forename error
		
		
		try {
			String expForename = "Forename is required";
			
			//Actual error message
			WebElement forename = driver.findElement(By.id("forename-err"));
			String actForename = forename.getText();
			System.out.println("Error message is: "+ actForename);
			
			//Assert expected error message is showing 
			System.out.println("Expected forename error is showing: " + actForename.contains(expForename));
		}catch (Exception e){
			System.out.println("Forename error is not displayed");
		}
	
		//Validate email error
		try {
			//Expected string
			String expEmail = "Email is required";
			
			//Actual error message
			WebElement email = driver.findElement(By.id("email-err"));
			String actEmail = email.getText();
			System.out.println("Error message is: "+ actEmail);
			
			//Assert expected error message is showing 
			System.out.println("Expected email error is showing: " + actEmail.contains(expEmail));
		}catch (Exception e){
			System.out.println("Email error is not displayed");
		}
		
		try {
			//Validate message error
	
			//Expected string
			String expMessage = "Message is required";
			
			//Actual error message
			WebElement message = driver.findElement(By.id("message-err"));
			String actMessage = message.getText();
			System.out.println("Error message is: "+ actMessage);
			
			//Assert expected error message is showing 
			System.out.println("Expected message error is showing: " + actMessage.contains(expMessage));
		}catch (Exception e){
			System.out.println("Message error is not displayed");
		}
			
	}

}


