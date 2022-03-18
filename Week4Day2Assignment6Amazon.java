package week4Day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Week4Day2Assignment6Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();	
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		WebElement mobilePrice = driver.findElement(By.xpath("//span[text()='64,999']"));
		String text = mobilePrice.getText();
		System.out.println("The first diplyed Mobile Price "+text);
		WebElement mobileRating = driver.findElement(By.xpath("(//a[contains(@class,'a-link-normal s-underline-text')]//span)[2]"));
		String text2 = mobileRating.getText();
		System.out.println("No of PeopleRated first Mobiel "+text2);
		WebElement starElement = driver.findElement(By.xpath("(//a[@role='button']//i)[2]"));
		Actions builder = new Actions(driver);
		builder.click(starElement).perform();
		WebElement ratingPercent = driver.findElement(By.xpath("(//a[@title='5 stars represent 65% of rating'])[3]"));
		String text3 = ratingPercent.getText();
		System.out.println("Percentage for 5 star "+text3);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		Set<String> allWindowHandleSet = driver.getWindowHandles();		
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);
		
		// Get the unique reference from the list
		String newWindow = allWindowHandleList.get(1);
		
		// Switching to the new window
		driver.switchTo().window(newWindow);
		driver.findElement(By.id("add-to-cart-button")).click();
		WebElement cartAmt = driver.findElement(By.id("attach-accessory-cart-subtotal"));
		String text4 = cartAmt.getText();
		System.out.println(text4);
		String replaceAll = text4.replaceAll("['a-zA-Z?']", "");
		if(text.equals(replaceAll))
		{
			System.out.println("Price Equeal");
		}
		
	}
	
	
	}


