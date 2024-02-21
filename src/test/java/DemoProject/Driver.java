package DemoProject;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

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
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				break;
			case 2:
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("You have entered a wrong Choice.");
				break;
		}
		return driver;
	}

}
