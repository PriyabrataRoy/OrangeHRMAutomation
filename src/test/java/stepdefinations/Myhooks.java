package stepdefinations;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Myhooks {

    @Before
    public void setup() {

        BaseTest.driver = new ChromeDriver();

        BaseTest.driver.manage().window().maximize();

        BaseTest.driver.get(
        		"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearUp() {

        BaseTest.driver.quit();
    }
}