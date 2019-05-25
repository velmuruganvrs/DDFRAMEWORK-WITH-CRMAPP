package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase {
	
	@Test
	public void Testmethod() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\rivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.crmpro.com/index.html");
		
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[1]")).sendKeys("velmurugan");
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[2]")).sendKeys("9789679298");
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/input")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("mainpanel");
		
		Thread.sleep(2000);
		
		Actions a = new Actions(driver);
		
		WebElement element=driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/a"));
		WebElement elementnew =driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/ul/li[1]/a"));
		
		a.moveToElement(element).moveToElement(elementnew).click().build().perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='first_name']")).sendKeys("velmurugan");
		driver.findElement(By.xpath(".//*[@id='surname']")).sendKeys("R");
		
		
		
	}

}
