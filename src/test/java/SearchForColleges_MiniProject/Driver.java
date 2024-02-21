package SearchForColleges_MiniProject;
import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver{
	public static WebDriver getWebDriver() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Your Browser: (1/2)?");
		System.out.println("1. Chrome Browser");
		System.out.println("2. Edge Browser");
		int choice = sc.nextInt();
		WebDriver driver = null;
		
		
		switch(choice)
		{
			case 1:
				driver= new ChromeDriver();
				break;
			case 2:
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("You have entered a wrong Choice.");
				break;
		}
		return driver;
	}
}