package Week4Day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement firstElement = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[2]"));
		WebElement secondElement = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[4]"));
		WebElement thirdElement = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[6]"));
		Actions builder=new Actions(driver);
		builder.keyDown(Keys.CONTROL).
		click(firstElement).click(secondElement).click(thirdElement)
		.keyUp(Keys.CONTROL).perform();
		
	}

}
