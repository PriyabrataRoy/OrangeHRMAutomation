package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumUtilities.ReusableFunctions;

public class AdminPage {
	WebDriver driver;
	  ReusableFunctions rf;
	  
	  public AdminPage(WebDriver driver) {
		  this.driver=driver;
		  PageFactory.initElements( driver,this);
		  rf=new ReusableFunctions(driver);
	  }
	  
	//click on admin tab  
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminbtn;
	public void clickadmin() {
		rf.clickElement(adminbtn);
	}
	
	//search user
	@FindBy(xpath="(//input[contains(@class, 'oxd-input--active')])[2]")
	WebElement searchUser;
	public void SearchUser(String value) {
		rf.waitTime(searchUser);
		rf.insertText(searchUser, value);
	}
	
	//searchbtn
	@FindBy(xpath="//button[text()=' Search ']")
	WebElement searchbtn;
	public void clicksearch() {
		rf.clickElement(searchbtn);
	}
	
	//add new user
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement adduserbtn;
	public void clickadduser() {
		rf.clickElement(adduserbtn);
	}
	
	//select userrole
	@FindBy(xpath = "//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']")
	WebElement drpUserRole;
	public void selectUserRoleUsingLoop(String roleToSelect) {
	    rf.clickElement(drpUserRole);
	    
	    try { 
	    	Thread.sleep(1000);
	    	} catch (InterruptedException e) {
	    		e.printStackTrace(); 
	    	}
	   
	    List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@role='listbox']//div[@role='option']"));
	    
	    System.out.println("Total options milay: " + dropdownOptions.size());
	   
	    for (WebElement option : dropdownOptions) {
	        String currentText = option.getText().trim();
	        System.out.println(currentText);
	        if (currentText.equalsIgnoreCase(roleToSelect)) {
	            option.click();
	            System.out.println("Successfully clicked on: " + roleToSelect);
	            break;
	        }
	    }
	}
	
	
	//select status
	@FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']")
	WebElement drpStatus;
	public void selectStatusUsingLoop(String statusToSelect) {
	    rf.clickElement(drpStatus);
	    
	    try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
	    
	    List<WebElement> statusOptions = driver.findElements(By.xpath("//div[@role='listbox']//div[@role='option']"));
	    
	    System.out.println("Total Status options milay: " + statusOptions.size());
	    
	    for (WebElement option : statusOptions) {
	        String currentText = option.getText().trim();
	        System.out.println(currentText);
	        
	        if (currentText.equalsIgnoreCase(statusToSelect)) {
	            option.click();
	            System.out.println("Successfully selected status: " + statusToSelect);
	            break;
	        }
	    }
	}
	
	//enter employeename
//	@FindBy(xpath="//input[@placeholder='Type for hints...']")
//	WebElement Empname;
//	public void enterName(String value) {
//		rf.waitTime(Empname);
//		rf.insertText(Empname, value);
//	}
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement Empname;
	public void enterName(String value) {
		rf.waitTime(Empname);
		Empname.clear(); 
		rf.insertText(Empname, value);
		
		try {
			// OrangeHRM background se hints/suggestions fetch karne me thoda time leta hai
			Thread.sleep(2000); 
			
			// Dynamic dropdown options ka locator
			By optionsLocator = By.xpath("//div[@role='listbox']//div[@role='option']");
			List<WebElement> options = driver.findElements(optionsLocator);
			
			if (options.size() > 0) {
				// Jo sabse pehla option milega uspar click kar dega
				System.out.println("Suggestion mila: " + options.get(0).getText());
				options.get(0).click();
				System.out.println("Employee Name successfully dropdown se select ho gaya!");
			} else {
				System.out.println("Warning: '" + value + "' ke sath koi employee match nahi hua!");
			}
		} catch (Exception e) {
			System.out.println("Autocomplete handle karne me exception aayi: " + e.getMessage());
		}
	}
	
	
	//enter username
	@FindBy(xpath="(//input[contains(@class, 'oxd-input--active')])[2]")
	WebElement Username;
	public void Username(String value) {
		rf.waitTime(Username);
		rf.insertText(Username, value);
	}
	
	//enter password
	//@FindBy(xpath="(//input[contains(@class, 'oxd-input--active')])[3]")
	@FindBy(xpath="//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input[@type='password']")
	WebElement pass;
	public void password(String value) {
		rf.waitTime(pass);
		rf.insertText(pass, value);
	}
	
	//confirmpassword
	//@FindBy(xpath="(//input[contains(@class, 'oxd-input--active')])[4]")
	@FindBy(xpath="//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input[@type='password']")
	WebElement Confpass;
	public void confPass(String value) {
		rf.waitTime(Confpass);
		rf.insertText(Confpass, value);
	}
	
	
	//savebtn
		@FindBy(xpath="//button[text()=' Save ']")
		WebElement savebtn;
		public void clicksave() {
			rf.clickElement(savebtn);
		}
		
    //edit user
		public void clickEditButtonForUser(String usernameToEdit) {
			String editXpath = "//div[text()='" + usernameToEdit + "']/ancestor::div[@role='row']//button[i[contains(@class,'bi-pencil-fill')]]";
			WebElement editBtn = driver.findElement(By.xpath(editXpath));
			rf.waitTime(editBtn);
			rf.clickElement(editBtn);
			System.out.println("Clicked Edit button for user: " + usernameToEdit);
		}
		
	//update username
		public void updateNewUsername(String newUsernameValue) {
			rf.waitTime(Username);
			Username.clear(); 
			rf.insertText(Username, newUsernameValue);
			System.out.println("Username field updated with: " + newUsernameValue);
		}
		
		
	 //delete user
		
		@FindBy(xpath = "//button[contains(.,'Yes, Delete')]")
		WebElement btnYesDeleteConfirmation;
		
		public void clickDeleteButtonForUser(String usernameToDelete) {
			String deleteXpath = "//div[text()='" + usernameToDelete + "']/ancestor::div[@role='row']//button[i[contains(@class,'bi-trash')]]";
			WebElement deleteBtn = driver.findElement(By.xpath(deleteXpath));
			rf.waitTime(deleteBtn);
			rf.clickElement(deleteBtn);
			System.out.println("Clicked Delete button for user: " + usernameToDelete);
			
			rf.waitTime(btnYesDeleteConfirmation);
			rf.clickElement(btnYesDeleteConfirmation);
			System.out.println("Confirmed 'Yes, Delete' from pop-up!");
		}
}
