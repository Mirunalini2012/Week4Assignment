package week4Day1Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1Assignment3Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//WebElement frame1 = driver.findElement(By.id("frame1"));
		//driver.switchTo().frame(frame1);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Not a Friendly topic");
		//WebElement frame3 = driver.findElement(By.id("frame3"));
		//driver.switchTo().frame(frame3);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@style='color:green']/following-sibling::input")).click();
		driver.switchTo().defaultContent();
		//WebElement frame2 = driver.findElement(By.id("frame2"));
		//driver.switchTo().frame(frame2);		
		//driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("(//select[@class='col-lg-3']/option)[2]")).click();
      
	}

}
