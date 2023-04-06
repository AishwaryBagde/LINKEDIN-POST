package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.hc.core5.http.nio.entity.NoopEntityConsumer;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        // 1. Launch Browser (Chrome) :ChromeDriver()
        // 1.2 Maximize Window :driver.windows().manage().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.windows().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
        // 2. Load URL :https://www.linkedin.com/home
        driver.get("https://www.linkedin.com/home");
        Thread.sleep(3000);
        // 3. Locate the Email text Box & Enter Email "PLEASE ENTER YOUR EMAIL ID"  Using Locator "ID":"session_key" / sendKeys("");
        WebElement emailTxtBox = driver.findElementById("session_key");
        emailTxtBox.click();
	//IF YOU ARE TRYING TO RUN THIS CODE PLEASE ENTER YOUR EMAIL ID
        emailTxtBox.sendKeys("");
        Thread.sleep(3000);
        // 4. Locate the Password text Box & Enter Password "PLEASE ENTER YOUR PASSWORD"  Using Locator "ID":"session_password" / sendKeys("");
        WebElement passTxtBox = driver.findElementById("session_password");
        passTxtBox.click();
	//IF YOU ARE TRYING TO RUN THIS CODE PLEASE ENTER YOUR PASSWORD
        passTxtBox.sendKeys("");
        Thread.sleep(3000);
        // 5. Click on Sign in button Using Locator "XPath":"//button[@data-id='sign-in-form__submit-btn']" / click();
        WebElement signIn =  driver.findElementByXPath("//button[@data-id='sign-in-form__submit-btn']");
        signIn.click();
        Thread.sleep(1000);
        // 6. Locate the name Present on the page And Print it Using Locator "XPath":"//div[@class='t-16 t-black t-bold']" / getText();
        WebElement name = driver.findElementByXPath("//div[@class='t-16 t-black t-bold']");
        System.out.println("The Username is : "+ name.getText());
        Thread.sleep(1000);
        // 7. Locate the "Connect with Alumni" And Print the No Using Locator "XPath":"(//span[@class='feed-identity-widget-item__stat'])[1]" / getText();
        WebElement connectWithAlumni = driver.findElementByXPath("(//span[@class='feed-identity-widget-item__stat'])[1]");
        System.out.println("The No for Connect with Alumni is : "+ connectWithAlumni.getText());
        Thread.sleep(1000);
        // 8. Locate the "Who's veiwed your Profile" And Print the No Using Locator "XPath":"(//span[@class='feed-identity-widget-item__stat'])[2]" / getText();
        WebElement viewedProfile = driver.findElementByXPath("(//span[@class='feed-identity-widget-item__stat'])[2]");
        System.out.println("Who's veiwed your Profile : " +viewedProfile.getText());
        Thread.sleep(1000);
        // 9. Click on "Start Post"  Using Locator "XPath":"//span[text()='Start a post']" / click();
        WebElement startPostBtn = driver.findElementByXPath("//span[text()='Start a post']");
        startPostBtn.click();
        Thread.sleep(1000);
        // 10. Locate the Text Box And Write "This Post Is Written using Selenium Code!" Using Locator "XPath":"//div[@role='textbox']" / sendKeys("This Post Is Written using Selenium Code!")
        WebElement textBox = driver.findElementByXPath("//div[@role='textbox']");
        textBox.click();
        textBox.sendKeys("This Post Is Written using Selenium Code!!");
        Thread.sleep(1000);

        //10.5 Verify if the Drop down Already has "Connection Only" Option Selected IF selected move to Step 14 Using Locator "XPath":"(//span[@class='share-state-change-button__label'])[1]"
        WebElement verifyDropDownOption = driver.findElementByXPath("(//span[@class='share-state-change-button__label'])[1]");
        if(!verifyDropDownOption.getText().equals("Connections only")) {
            System.out.println("Selecting Connections Option");
            
        // 11. Locate the DropDown and click on it Using Locator "XPath":"(//li-icon[@class='share-state-change-button__icon'])[2]" / click();
        WebElement dropDwon = driver.findElementByXPath("(//li-icon[@class='share-state-change-button__icon'])[2]");
        dropDwon.click();
        Thread.sleep(1000);
        // 12. Locate the "CONNECTIONS_ONLY" Option and click on it Using Locator "ID":"CONNECTIONS_ONLY" / click();
        WebElement selectOption = driver.findElementById("CONNECTIONS_ONLY");
        selectOption.click();
        Thread.sleep(1000);
       
        // 13. Locate the "Save" button and Click on it Using Locator "XPath":"(//button[@type='button'])[5]" / click();
        WebElement saveBtn = driver.findElementByXPath("(//button[@type='button'])[5]");
        saveBtn.click();
        Thread.sleep(1000);

        } else{
            System.out.println("Connection Only Option Already Selected ");
        }

         // 14. Locate the "Post" button and Click on it Using Locator "XPath":"//div[@class='share-box_actions']" / click();
         WebElement postBtn = driver.findElementByXPath("//div[@class='share-box_actions']");
         postBtn.click();
         Thread.sleep(3000);

        // 15 Verify That The post is Successfull Using Locator "XPath":"(//div[@class='update-components-text relative feed-shared-update-v2__commentary '])[1]"
        WebElement postTxt = driver.findElementByXPath("(//div[@class='update-components-text relative feed-shared-update-v2__commentary '])[1]");
        System.out.println("The Post Text is : " + postTxt.getText());
     
    }


}

