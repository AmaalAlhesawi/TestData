package MySetupTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {

	Connection con;
	Statement stmt;
	ResultSet rs;

	
	WebDriver driver=new ChromeDriver();
	
	String firstname;
	String customerID;
	String customerphone;
	String lastname;
	Random rand=new Random();
	
	int NumInput=rand.nextInt(9960);

	String NameForSignup=firstname+lastname+NumInput;
	String PassWL="Amaal";
	
	
}
