package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnnotationPriority {
	WebDriver driver;
	@Test(priority=1)
	void OpenApp() {
		driver=new EdgeDriver();
		driver.get("https://demo.guru99.com/v4");
		
	}
	@Test(priority=2)
	void Login() {
		driver.findElement(By.name("uid")).sendKeys("mngr512103");
		driver.findElement(By.name("password")).sendKeys("ahUdAsA");
		driver.findElement(By.name("btnLogin")).click();
		
	}
	@Test(priority=3)
	void search() {
		System.out.println("search");
		
	}
	@Test(priority=4)
	void CloseApp() {
		driver.close();
		
	}



@DataProvider(name="DP")
String [][] LoginData()
{
	String data[][]={
	{"Priya@Gmail.com", "xyz"},
	{"Ravi@yahoo.com", "123"},
	{"mngr512103","ahUdAsA"}
}; return data;
}
}
