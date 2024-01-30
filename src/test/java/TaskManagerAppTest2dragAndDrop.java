import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class TaskManagerAppTest2dragAndDrop {
    public static void main(String args[]) {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\anjal\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://qataskmanager.ccbp.tech/");


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Task Manager']")));

        Actions a=new Actions(driver);

        WebElement source=driver.findElement(By.cssSelector("div#task1"));
        System.out.println(source.getText());
        WebElement target=driver.findElement(By.cssSelector("section#done"));

        a.dragAndDrop(source,target).perform();

        List<WebElement> taskEle=driver.findElements(By.xpath("//section[@id='done']//div[contains(@class,'task')]"));
        System.out.println(taskEle.size());
        if(taskEle.size()==1){
            System.out.println("Task is moved to done stage");
        }
        else{
            System.out.println("Task is not moved to done stage");
        }
        driver.quit();
    }
}
