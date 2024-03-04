package Axis.SeleniumGrid;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4GridTest  extends HelperClass{
	 
    @Test
    public void invalidCredentials() throws InterruptedException {
         
        getDriver().findElement(By.xpath("//input[@name = 'username']")).sendKeys("1234");
        getDriver().findElement(By.xpath("//input[@name = 'password']")).sendKeys("12342");
        getDriver().findElement(By.xpath("//button[@type = 'submit']")).click();
        Thread.sleep(1000);
        String actualErrorMessage = getDriver().findElement(By.xpath("//*[@class='oxd-alert-content oxd-alert-content--error']")).getText();
        System.out.println("Actual ErrorMessage :" + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage,"Invalid credentials");

    }

    @Test
    public void loginPageHeading() {

        String loginText = getDriver().findElement(By.xpath("//*[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).getText();
        System.out.println("Actual loginText :" + loginText);
        Assert.assertEquals(loginText,"Login");

    }

   
}
	
	


