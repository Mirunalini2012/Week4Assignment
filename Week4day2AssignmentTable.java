package Week4Day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4day2AssignmentTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement elementTable = driver.findElement(By.id("table_id"));		
		List<WebElement> rows  = elementTable.findElements(By.tagName("tr"));			
		System.out.println("Number of Rows: "+rows.size());
		WebElement row = rows.get(1);
		List<WebElement> cols = row.findElements(By.tagName("td"));
		System.out.println("Number of Cols: "+ cols.size());		
		List<String> names=new ArrayList<String>();
		List<String> cmpnames=new ArrayList<String>();
		System.out.println("");
		for (int i = 1; i < rows.size(); i++) {
			WebElement eachRow = rows.get(i);
			WebElement tdColData = eachRow.findElements(By.tagName("td")).get(1);
			//System.out.println(tdColData.getText());
			names.add(tdColData.getText());
				}
		Collections.sort(names);
		System.out.println("The Sorted List");
		for (int i = 0; i < names.size(); i++) {			
			System.out.println(names.get(i));
			
		}	
		System.out.println("");
		System.out.println("Sorted by names header");
		driver.findElement(By.xpath("(//th[@class='sorting'])[1]")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//td[@class='sorting_1']"));
		for (int i = 0; i < findElements.size(); i++) {
			System.out.println(findElements.get(i).getText());
			cmpnames.add(findElements.get(i).getText());
		}
		System.out.println("");
		System.out.println("Final Comparison");
		for (int i = 0; i < cmpnames.size(); i++) {	
			if(cmpnames.get(i).equals(names.get(i)))
			{
			System.out.println(names.get(i));
			
		}	
		
		}
		}	
	}

