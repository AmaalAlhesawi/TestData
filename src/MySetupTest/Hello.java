package MySetupTest;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.Select;



public class Hello extends TestData {
	
	
	
	
	
	@BeforeTest

	public void MyBeforTest() throws SQLException {
		driver.get("https://automationteststore.com/");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Amaal");
		
		
}
	

	@Test(priority = 1, enabled=false)
	public void MyTestAddData() throws SQLException  {
	
	stmt=con.createStatement();
	String Query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) VALUES (9991, 'Raghad Obidat Trading', 'Obidat', 'Raghad', '+962-7-9000-1234', 'Al Rabieh Street', NULL, 'Amman', NULL, '11118', 'Jordan', 1370, 75000.00);";
	stmt.executeUpdate(Query);
	
	}	
	
	
	
	@Test(priority = 2)
	public void ReadData() throws SQLException  {
	
	stmt=con.createStatement();
	String Query="select * from customers where customerNumber=9991;";
	rs=stmt.executeQuery(Query)	;
	while(rs.next()) {
		
		 firstname=rs.getString("customerName");
		 customerID=rs.getString("customerNumber");
		 customerphone = rs.getString("phone");
         lastname=rs.getString("contactLastName");
		
	
		
		System.out.println(firstname);
		System.out.println(customerID);
		System.out.println(customerphone);
		
	
	}
		
	}	
	
	

	@Test(priority = 3)
	public void SignupWithDatabase() throws InterruptedException {
		//driver.get("https://automationteststore.com/");
		WebElement Loginorregister=driver.findElement(By.linkText("Login or register"));
		Loginorregister.click();
		
		WebElement CountineButton=driver.findElement(By.xpath("//button[@title='Continue']"));
		CountineButton.click();
		String TheEmail=firstname+lastname+NumInput+"@gmail.com";
		System.out.println(TheEmail);
		
		// elements
		WebElement FirstNInput=driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNInput=driver.findElement(By.id("AccountFrm_lastname"));
		WebElement InputEmail=driver.findElement(By.id("AccountFrm_email"));
		WebElement AddressInput=driver.findElement(By.id("AccountFrm_address_1"));
		WebElement CountryInput=driver.findElement(By.id("AccountFrm_country_id"));
		WebElement ZoneStateInput = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginName=driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInp=driver.findElement(By.id("AccountFrm_password"));
		WebElement ConfirmPasswordp=driver.findElement(By.id("AccountFrm_confirm"));
		WebElement AgreeAcount=driver.findElement(By.id("AccountFrm_agree"));
		WebElement CountinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		
		
		// Actions 
		FirstNInput.sendKeys(firstname);
		LastNInput.sendKeys(lastname);
		InputEmail.sendKeys(TheEmail);
		AddressInput.sendKeys("Amman");
		Select CountrySelect=new Select(CountryInput);
		CountrySelect.selectByValue("108");
		Thread.sleep(3000);
		int randzone = rand.nextInt(ZoneStateInput.findElements(By.tagName("option")).size());
		Select InputState = new Select(ZoneStateInput);
		InputState.selectByIndex(randzone);
		CityInput.sendKeys("RandomCity");
		PostalInput.sendKeys("customerphone");
		LoginName.sendKeys(NameForSignup);
		PasswordInp.sendKeys(PassWL);
		ConfirmPasswordp.sendKeys(PassWL);
		AgreeAcount.click();
		//CountinueButton.click();
		
		
		// Assertion 
		Assert.assertEquals(driver.getCurrentUrl().contains("success"), true);
		Assert.assertEquals(driver.getPageSource().contains("Congratulations"), true);
		WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));
		//Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);
	
	}
	
	
	@Test(priority = 4)
	public void MyTestToUpdate() throws SQLException  {
	
	stmt=con.createStatement();
	String Query = "UPDATE customers SET customerName = 'dana and raghad' WHERE customerNumber = 9991";
	stmt.executeUpdate(Query);
	
	}	
	
	@Test(priority = 5)
	public void MyTestToDelete() throws SQLException  {
	
	stmt=con.createStatement();
	String Query = "delete from customers where customerNumber = 9991";
	stmt.executeUpdate(Query);
	
	}	
	
	
}
