package org.ams.PNCSelaniumAMS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPageObject;
//import Pages.LoginPageObject;
import utility.WebDriverfactory;

public class Login {
	
	private WebDriver driver;
	
  @Test(priority=2,dataProvider="usernameandpassword", description="This Test case will run twice")
  	//@Test(priority=2)
  public void login(String username,String password) {
/*  driver.findElement(By.linkText("sign-in")).click();
  driver.findElement(By.name("userName")).clear();
  driver.findElement(By.name("userName")).sendKeys("Ams123");
  driver.findElement(By.name("password")).clear();
  driver.findElement(By.name("password")).sendKeys("amspassword");
  driver.findElement(By.name("login")).click();*/
	
  driver.navigate().back();
	  //Login page Object
	LoginPageObject.uname.clear();
	LoginPageObject.uname.sendKeys("invalidUN");
	LoginPageObject.pass.clear();
	LoginPageObject.pass.sendKeys("invalidPW");
	LoginPageObject.login_button.click();
	
  }
  
	
   @Test(priority=1)
	  public void register() {
	  driver.findElement(By.linkText("REGISTER")).click();
	  
	  driver.findElement(By.name("firstName")).sendKeys("Ams");
	  driver.findElement(By.name("lastName")).clear();
	  driver.findElement(By.name("phone")).sendKeys("9975440646");
	  driver.findElement(By.name("userName")).sendKeys("ams@gmail.com");
	  driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Accenture PDC 4 Phursungi");
	  driver.findElement(By.name("city")).sendKeys("Pune");
	  driver.findElement(By.name("state")).sendKeys("M H");
	  driver.findElement(By.name("postalCode")).sendKeys("411028");	  
	  
	//Creating Class for Drop Down for country 
	  Select country = new Select(driver.findElement(By.name("country"))); //Cnt + shift + O
	  country.selectByVisibleText("INDIA");
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Ams123");
	  driver.findElement(By.name("password")).sendKeys("amspassword");
	  driver.findElement(By.name("confirmPassword")).sendKeys("amspassword");
	  driver.findElement(By.name("register")).click();
	  }
	
   @DataProvider(name="usernameandpassword")
   public String[][] credentials(){
	   return new String[][] {
		   new String [] {"invalidUN","invalidPW"},
		   new String [] {"username1","password1"}
	   };
   }
   
  @BeforeTest
  public void beforeTest() {
	 // System.setProperty("webdriver.chrome.driver","C:\\Users\\pdc4-training.pdc4"+"\\Desktop\\Ams\\Selenium drivers\\chromedriver.exe");
		//			  driver = new ChromeDriver();
	  
	  	driver = WebDriverfactory.createDriver();
	  		driver.manage().window().maximize();
	  		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );//wait time- implicit
	  		//driver.get("http://newtours.demoaut.com/");
	  
	  	driver.navigate().to("http://newtours.demoaut.com/");// as we r using navigate so replaced
		PageFactory.initElements(driver,LoginPageObject.class );
	  		  }

  @AfterTest
  public void afterTest() {
  }

}
