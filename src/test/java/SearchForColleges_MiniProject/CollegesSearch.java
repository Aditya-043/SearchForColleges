package SearchForColleges_MiniProject;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CollegesSearch{ 
	public static void main(String[] args) throws Exception {
		
		// Driver Setup
		WebDriver driver = Driver.getWebDriver();
		
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximize the window
		driver.manage().window().maximize();
		
		//go to site 
		driver.get("https://www.eduvidya.com/");
		
		// get path of Excel File
		String file = System.getProperty("user.dir")+"\\ExcelFiles\\Book1.xlsx";
		
		// Find No of Rows
		int rows = ExcelUtils.getRowCount(file, "Sheet1");
		
		// Handle Browser Security alerts (if any) 
		try {
			// Click on Details Button
			WebElement detailsButton = driver.findElement(By.id("details-button"));
			detailsButton.click();
			Thread.sleep(3000);
			
			// Click on Proceed Link
			WebElement proceedLink = driver.findElement(By.id("proceed-link"));
			proceedLink.click();			
		}
		catch(Exception ignored) {
			// No Security alert Found
		} 
		
		// Click on Colleges
		driver.findElement(By.linkText("Colleges")).click();
		
		// Handle Ads if any
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while(elements.length > 0) elements[0].remove()");
		
		// Again Click on College
		driver.findElement(By.linkText("Colleges")).click();
		
		
		for(int i=0; i<=rows; i++)
		{
			//Read data from excel
			String category = ExcelUtils.getCellData(file, "Sheet1", i, 0);
			String state = ExcelUtils.getCellData(file, "Sheet1", i, 1);
			
			//Pass Data to the application.
			// Select Science from ExcelSheet
			Select drop1 = new Select(driver.findElement(By.id("ddl_Category")));
			drop1.selectByVisibleText(category);
			Thread.sleep(3000);
			
			//Select Chennai from ExcelSheet.
			Select drop2 = new Select(driver.findElement(By.id("ddl_City")));
			drop2.selectByVisibleText(state);
			Thread.sleep(3000);
		}
		
		// Click on Search Button
		driver.findElement(By.id("btnSearch")).click();
		
		// Validate the page
		String act_title = driver.getTitle();
		String exp_title = "Search Colleges";
		
		if(act_title.equals(exp_title))
		{
			System.out.print("Window Validated");
		}
		else {
			System.out.print("Window Validation Failed");
		}
		
		// close driver
		driver.quit();
	}
}

