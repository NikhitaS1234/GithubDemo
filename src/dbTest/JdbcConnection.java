package dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class JdbcConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String host="localhost";
		String port="3306";
	//	Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/QAdb1","root","Nikhita1@dhanesh2");
		Statement s= con.createStatement();
        ResultSet rs=s.executeQuery("select *from Employeedetails where name='neha'");
        
        while(rs.next())
        {
        	
    		ChromeOptions options=new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*");
    		
    		WebDriver driver=new ChromeDriver(options);
    		driver.get("https://www.linkedin.com/home");
    		driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys(rs.getString("name"));
    		driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys(rs.getString("password"));
          // System.out.println( rs.getString("name"));
         //System.out.println( rs.getString("password"));
	}

}
}
