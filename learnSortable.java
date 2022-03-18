package Week4Day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class learnSortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement clickElement = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[1]"));
		//WebElement firstElement = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[3]"));
		WebElement moveElement = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[4]"));
		//org.openqa.selenium.Point location= firstElement.getLocation();
		Actions builder=new Actions(driver);
		builder.clickAndHold(clickElement).moveToElement(moveElement).release().perform();
		
		
	}

}
