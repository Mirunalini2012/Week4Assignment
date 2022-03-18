package Week4Day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mongodb.client.model.geojson.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnResizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement findFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(findFrame);		
		WebElement sourceElement = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle ui-resizable-se')]"));
	    Actions builder=new Actions(driver);
		builder.clickAndHold().dragAndDropBy(sourceElement, 50, 50).perform();
		
		
		
		

	}

}
