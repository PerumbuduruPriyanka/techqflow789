package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DependsOnMethod {
	WebDriver driver;
	@Test(priority=1)
	void OpenApp() {
		driver=new EdgeDriver();
		driver.get("https://demo.guru99.com/v4");
	}
	@Test(priority=2,dependsOnMethods= {"OpenApp"})
	void Login() {
		driver.findElement(By.name("uid")).sendKeys("mngr512103");
		driver.findElement(By.name("password")).sendKeys("ahUdAsA");
		driver.findElement(By.name("btnLogin")).click();
		
	}
	@Test(priority=3,dependsOnMethods= {"Login"})
	void search() {
		System.out.println("search");
		
	}
	@Test(priority=4,dependsOnMethods= {"OpenApp"})
	void CloseApp() {
		driver.close();
		
	}

}
