package week4Day1Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1Assignment4Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		WebElement frameNested = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[2]"));
		driver.switchTo().frame(frameNested);
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().defaultContent();		
List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
		
		int size = outerframe.size();
		System.out.println(size+" frames are in outerframes");
		
		
		for(int i=0;i<outerframe.size();i++) {
			driver.switchTo().frame(outerframe.get(i));//0,1,2
			List<WebElement> innerFrame = driver.findElements(By.tagName("iframe"));//0,1,1
		    size = size + innerFrame.size();//3+0=3+1=4+1=5
		    driver.switchTo().defaultContent();//will pass the control to main body
		    
			 			//driver.switchTo().parentFrame();//will pass the control to parent frame
	}
		System.out.println("Totally "+size+" frames are in page");
	}
}
