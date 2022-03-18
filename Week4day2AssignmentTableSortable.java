package Week4Day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4day2AssignmentTableSortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement elementTable = driver.findElement(By.id("table_id"));		
		List<WebElement> rows  = elementTable.findElements(By.tagName("tr"));			
		System.out.println("Number of Rows: "+rows.size());
		WebElement row = rows.get(1);
		List<WebElement> cols = row.findElements(By.tagName("td"));
		System.out.println("Number of Cols: "+ cols.size());
		
		
		WebElement row3 = rows.get(3);
		String text = row3.findElement(By.xpath("((//table[@id='table_id']//tr)[3]/td)[2]")).getText();
		System.out.println("The progress value of 'Learn to interact with Elements' is "+text);
		
		
		//String text2 = driver.findElement(By.xpath("//table[@id='table_id']//tr[2]/td[2]")).getText();
		//System.out.println(text2);
		
		Set<String> percent = new LinkedHashSet<String>();
		List<String> listPercent = new ArrayList<String>();
		for(int i=2;i<=rows.size();i++)
		{
			String text3 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			//System.out.println(text3);
			//String replace = text3.replaceAll("['a-zA-Z%']", "");
			percent.add(text3);
			
		}
		listPercent.addAll(percent);
		
		System.out.println("The sorted list in descending order");
		
		for(int j=0 ; j<listPercent.size();j++)
		{
		
			System.out.println(listPercent.get(j));
			
		
		}
			
		int size=listPercent.size()-1;
		String leastpercent = listPercent.get(size);
		System.out.println("The Least percentage is " +leastpercent);
		
		for(int i=2;i<=rows.size();i++)
		{
			String checkdata = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			if(leastpercent.equals(checkdata))
			{
				System.out.println("Matching");
				driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[3]/input")).click();
				
			}
		
		}
		
		
		
		
		
		
		/*
		for (int i = 1; i < rows.size(); i++) {
			WebElement eachRow = rows.get(i);
			WebElement tdColData = eachRow.findElements(By.tagName("td")).get(1);
			//percent.add(tdColData.getText().replaceAll("['a-zA-Z%']", ""));
			if(tdColData.getText().equals("30%")) {
				eachRow.findElements(By.xpath("//td/input")).get(2).click();
			}
			
		}
					
		*/	
		
		
		}
		
	}


