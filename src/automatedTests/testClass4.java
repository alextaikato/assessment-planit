package automatedTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class testClass4 {
	
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
		driver.findElement(By.linkText("Shop")).click();
		
		//Click funny cow twice
		driver.findElement(By.id("product-6")).findElement(By.className("btn")).click();
		driver.findElement(By.id("product-6")).findElement(By.className("btn")).click();
		
		//Click fluffy bunny once
		driver.findElement(By.id("product-4")).findElement(By.className("btn")).click();
		
		//Navigate to cart
		driver.findElement(By.className("icon-shopping-cart")).click();
		
		//Save table
		WebElement cart = driver.findElement(By.className("cart-items"));
		//Print table rows
		boolean funnyCow= false;
		boolean fluffyBunny= false;
		List<WebElement> rows = cart.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
		    List<WebElement> cols = row.findElements(By.tagName("td"));
		    for (WebElement col : cols) {
		    	if (col.getText().equals("Funny Cow")) {
		    		fluffyBunny = false;
		    		funnyCow = true;
		    	}else if(col.getText().equals("Fluffy Bunny")) {
		    		funnyCow = false;
		    		fluffyBunny = true;
		    	}
		    	try {
		    		WebElement quantity = col.findElement(By.tagName("input"));
		    		String quantityVal = quantity.getAttribute("value");
		    		if (funnyCow ==true) {
		    			System.out.print("There are: " + quantityVal + " Funny Cows in the cart.");
		    		} else if(fluffyBunny==true) {
		    			System.out.print("There are: " + quantityVal + " Fluffy Bunnies in the cart.");
		    		}
		    	}catch (Exception e) {
		    		
		    	}
		        
		    }
		    System.out.println();
			}
		}
	
		

}


