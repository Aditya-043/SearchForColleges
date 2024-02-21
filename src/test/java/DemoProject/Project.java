package DemoProject;
import java.io.File;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import SearchForColleges_MiniProject.Driver;

public class Project {

	public static void main(String[] args) throws Exception {
		
		
		WebDriver driver = Driver.getWebDriver();
		
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//go to site 
		driver.get("https://www.eduvidya.com/");
		
		
		// Maximize the window
		driver.manage().window().maximize();
		
		// Click on Details Button
		WebElement detailsButton = driver.findElement(By.id("details-button"));
		detailsButton.click();
		Thread.sleep(3000);
			
		// Click on Proceed Link
		WebElement proceedLink = driver.findElement(By.id("proceed-link"));
		proceedLink.click();			
		
		// Click on Colleges
		driver.findElement(By.linkText("Colleges")).click();
		
		// Get File Location 
		File file1 = new File(System.getProperty("user.dir")+"\\ExcelFiles\\Book1.xlsx");
		List<String> excelData = ExcelSetup.getData(file1);
		
		
		// Select Science from Drop Down1 from 
		WebElement drp1 = driver.findElement(By.id("ddl_Category"));
		Select drop1 = new Select(drp1);
		drop1.selectByVisibleText(excelData.get(0));
		Thread.sleep(3000);
		
		//Select Chennai From DropDown2
		WebElement drp2 = driver.findElement(By.id("ddl_City"));
		Select drop2 = new Select(drp2);
		drop2.selectByVisibleText(excelData.get(1));
		Thread.sleep(3000);
		
		// Click on Search Button
		driver.findElement(By.id("btnSearch")).click();
				
		// Validate the page
		String act_title = driver.getTitle();
		String exp_title = "Search Colleges";
				
		if(act_title.equals(exp_title))
		{
			System.out.print("Window has been Validated");
		}
		else {
			System.out.print("Window Validation Failed");
		}
		
		//Close the Browser
		driver.quit();
		
	}

}
