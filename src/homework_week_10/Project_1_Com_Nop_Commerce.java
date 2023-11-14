package homework_week_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */
public class Project_1_Com_Nop_Commerce {

    static String browser = "firefox";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        //Launch the  browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //open URL into Chrome Browser
        driver.get(baseUrl);

        //maximise the page
        driver.manage().window().maximize();

        //Print the title of page
        String title = driver.getTitle();
        System.out.println("The title of page is : " + title);

        //Print current URL
        System.out.println("The current URL is : " + driver.getCurrentUrl());

        //Print page source
        System.out.println("The page source is : " + driver.getPageSource());

        //Navigate to URL provided
        String providedUrl = "https://demo.nopcommerce.com/login?returnUrl=\n" + "%2F";
        driver.navigate().to(providedUrl);
        System.out.println("After navigating to provided URL, current URL is : " + driver.getCurrentUrl());

        //navigate back to home page
        driver.navigate().back();

        //Navigate to the login page
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=\n" + "%2F";
        driver.navigate().to(loginUrl);
        System.out.println("After navigating to login page, Current URL is : " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();

        //Enter the Email in email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("testNG123@gmail.com");

        //Enter password in password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("testNG");

        //Click the login button
        driver.findElement(By.className("login-button")).click();

        //close the browser
        driver.quit();
    }
}
