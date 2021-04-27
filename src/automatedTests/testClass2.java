package automatedTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class testClass2 {
	
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
		
		
		
		
		//Populate feilds
		populateFeilds(driver);
		
		//click submit
		driver.findElement(By.linkText("Submit")).click();
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Validate success
		validateSuccess(driver);
		
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
	
	public static void validateSuccess(WebDriver driver) {
		//Validate email error
		try {
			
			//Actual error message
			WebElement success = driver.findElement(By.className("alert-success"));
			String actSuccess = success.getText();
			System.out.println("Success message is: "+ actSuccess);
			
			
		}catch (Exception e){
			System.out.println("Success message is not showing");
		}
		
	}

}
