package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Myhooks {

    @Before
    public void setup() {

        BaseTest.driver = new ChromeDriver();

        BaseTest.driver.manage().window().maximize();
        
        BaseTest.driver.manage().timeouts()
        .pageLoadTimeout(Duration.ofSeconds(60));
        
        BaseTest.driver.get(
        		"https://opensource-demo.orangehrmlive.com");
        
        BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @After
    public void tearUp() {

        BaseTest.driver.quit();
    }
}