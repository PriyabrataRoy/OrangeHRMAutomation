package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumUtilities.ReusableFunctions;

public class ForgotPasswordPage {
  WebDriver driver;
  ReusableFunctions rf;
  
  public ForgotPasswordPage(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements( driver,this);
	  rf=new ReusableFunctions(driver);
  }
  
  @FindBy(xpath = "//p[text()='Forgot your password? ']")
  WebElement lnkForgotPassword;
  public void clickForgotPasswordLinkOnLoginPage() {
      rf.waitTime(lnkForgotPassword); 
      rf.clickElement(lnkForgotPassword); 
  }
  
  
  @FindBy(name = "username")
  WebElement txtResetUsername;
  public void enterResetUsername(String username) {
      rf.insertText(txtResetUsername, username);
  }

  
  @FindBy(xpath = "//button[text()=' Reset Password ']")
  WebElement btnResetPassword;
  public void clickResetPassword() {
      rf.clickElement(btnResetPassword);
  }

  
  @FindBy(xpath = "//h6[contains(@class,'orangehrm-forgot-password-title')]")
  WebElement msgSuccessTitle;
  public String getSuccessMessage() {
      rf.waitTime(msgSuccessTitle);
      return msgSuccessTitle.getText();
  }
}
