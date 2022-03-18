package Week4Day2Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4AssignmentSanpdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();	
		ChromeDriver driver = new ChromeDriver();
		
		 //main window
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement findElement = driver.findElement(By.xpath("(//a[@href='javascript:void(0);']//span)[2]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(findElement).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		System.out.println(driver.getCurrentUrl());
		String totalitems = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Count of Sports Shoes "+totalitems);	
		driver.findElement(By.xpath("//a[@href='/products/mens-training-shoes#bcrumbLabelId:255']")).click();
        driver.findElement(By.xpath("//i[contains(@class,'sd-icon sd-icon-expand-arrow')]")).click();
        driver.findElement(By.xpath("//li[@class='search-li']")).click();     
        driver.findElement(By.name("fromVal")).clear();
        driver.findElement(By.name("fromVal")).sendKeys("600");
        driver.findElement(By.name("toVal")).clear();
        driver.findElement(By.name("toVal")).sendKeys("1200");
        driver.findElement(By.xpath("//div[text()[normalize-space()='GO']]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
        WebElement findElement2 = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
        builder.moveToElement(findElement2).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[contains(@class,'center quick-view-bar')])[1]")).click();
        String text = driver.findElement(By.xpath("//span[text()='37% Off']")).getText();
        System.out.println("The discount price is "+text);
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
		// Create an image file to store the screen shot
		File image = new File("./snaps/sanpdeal.jpg");
		// Merging temp screenshot and image file togeather
		FileUtils.copyFile(screenShot, image);
		driver.quit();
	
		
		
	}

}
