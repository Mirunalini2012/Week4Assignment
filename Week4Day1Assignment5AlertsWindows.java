package week4Day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1Assignment5AlertsWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@class='text-center col-xs-12']/button")).click();
		driver.findElement(By.xpath(" (//li[@class='menu-list header-icon-menu']/a)[3]")).click();
		//String currentWindowHandle = driver.getWindowHandle();
		//System.out.println(currentWindowHandle);
		//Need to get all window references as a set
		System.out.println(driver.getCurrentUrl());
		Set<String> allWindowHandleSet = driver.getWindowHandles();
		
		// To get the unique value out of the Set, We are converting Set -> List
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);
		
		// Get the unique reference from the list
		String newWindow = allWindowHandleList.get(1);
		
		// Switching to the new window
		driver.switchTo().window(newWindow);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		String text = driver.findElement(By.xpath("//a[@href='mailto:flights@irctc.co.in']")).getText();
        System.out.println(text);
        driver.switchTo().defaultContent();
        driver.close();
		
		
				}

}
