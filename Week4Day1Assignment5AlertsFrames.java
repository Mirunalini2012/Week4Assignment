package week4Day1Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1Assignment5AlertsFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//body[@contenteditable='false']/button")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		//alert.accept();
		alert.dismiss();
		WebElement stirngText = driver.findElement(By.id("demo"));
		String text2 = stirngText.getText();
		//System.out.println(text2);
		
		if(text2.contains("OK"))
		{
			System.out.println("Pressed OK");
		}
		else
		{
			System.out.println("Pressed Cancel");
		}
		
		
				}

}
