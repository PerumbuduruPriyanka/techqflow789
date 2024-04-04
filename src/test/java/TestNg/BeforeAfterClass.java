package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAfterClass {
WebDriver driver;
@BeforeClass
void OpenApp() {
	driver=new EdgeDriver();
	driver.get("https://demo.guru99.com/v4");
	
}
@Test(priority=1)
void login() {
	driver.findElement(By.name("uid")).sendKeys("mngr512103");
	driver.findElement(By.name("password")).sendKeys("ahUdAsA");
	driver.findElement(By.name("btnLogin")).click();
	
}
@Test(priority=2)
void search() {
	System.out.println("search");
	
}

@AfterClass
void ClosApp() {
	driver.close();

}
}
