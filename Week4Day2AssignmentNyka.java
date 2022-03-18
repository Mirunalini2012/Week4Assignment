package Week4Day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Week4Day2AssignmentNyka {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		ChromeDriver driver = new ChromeDriver();
		
		//main window
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement findElement = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(findElement).perform();
		driver.findElement(By.xpath("//div[@id='scroller-container']/div[7]/a[1]")).click();
		String string = driver.getTitle();	
		if(string.contains("L'Oreal Paris"))
		{
			System.out.println("Title contains L'Oreal Paris");
			
		}
		
		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']/span")).click();
		driver.findElement(By.xpath("(//span[@class='title'])[4]")).click();
		driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj']/span)[1]")).click();
		driver.findElement(By.xpath("//ul[@id='custom-scroll']/ul[1]/li[2]/div[1]")).click();
		driver.findElement(By.xpath("//ul[@id='custom-scroll']/ul[1]/li[1]/ul[1]/li[1]/div[1]")).click();
		//shampoo selecting
		String text = driver.findElement(By.xpath("//div[@class='control-value']//span")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//label[@for='checkbox_Shampoo_316']//div)[2]")).click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='custom-scroll']/ul[1]/li[2]/div[1]")).click();
		driver.findElement(By.xpath("//ul[@id='custom-scroll']/ul[1]/li[1]/ul[1]/li[2]/div[1]")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_2045']//div)[2]")).click();
		String text2 = driver.findElement(By.className("filter-value")).getText();
		System.out.println(text2);
		if(text.equals(text2))
		{
			System.out.println("Same Filter");
		}
		
		driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
		Set<String> allWindowHandleSet = driver.getWindowHandles();		
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);
		
		//another window
		String newWindow = allWindowHandleList.get(1);
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(newWindow);
		System.out.println(driver.getCurrentUrl());		
		driver.findElement(By.xpath("(//button[@class=' css-1r0ze8m'])[1]")).click();
		String productCost = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		System.out.println("Product cost "+productCost);
		driver.findElement(By.xpath("(//button[@class=' css-n03g1c'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		//frame
		driver.switchTo().frame(0);
		String grandtotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String replaceAll = grandtotal.replaceAll("['?']", "");
		System.out.println("Grand Total "+replaceAll);
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		
		
		//cart window
		String newWindow2 = allWindowHandleList.get(1);
		driver.switchTo().window(newWindow2);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		//final window for cart
		String newWindow3 = allWindowHandleList.get(1);		
		driver.switchTo().window(newWindow3);
		System.out.println(driver.getCurrentUrl());
		String finaltotal = driver.findElement(By.xpath("(//div[@class='value']//span)[2]")).getText();
		System.out.println("Final Total " +finaltotal);
	
	if(replaceAll.equals(finaltotal))
	{
		System.out.println("The grand total matches");
	}
	
	}
	
	
	}


