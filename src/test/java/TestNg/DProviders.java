package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DProviders {
	WebDriver driver;
	@Test(priority=1)
void OpenApp() {
	driver=new EdgeDriver();
	driver.get("https://demo.guru99.com/v4");
}
	@Test(priority=2,dependsOnMethods= {"OpenApp"}, dataProvider="DP")
void Login(String UID,String PWD) {
	driver.findElement(By.name("uid")).sendKeys(UID);
	driver.findElement(By.name("password")).sendKeys(PWD);
	driver.findElement(By.name("btnLogin")).click();
	String ActText=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")).getText();
	String ExpText="Welcome To Manager's Page of Guru99 Bank";
	
	Assert.assertEquals(ActText, ExpText,"Text not macthing");
	
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
	{"Priya@Gmai.com", "xyz"},
	{"Ravi@Yahoo.com", "123"},
	{"mngr512103","ahUdAsA"}
}; return data;
}
}