package Interview_prgms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class All_page_elements_filters_pagination
{
    public static void main(String[] arg) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");

        WebElement mobiles = driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_mobiles']"));
        mobiles.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");

        WebElement onepluse = driver.findElement(By.xpath("//span[text()='OnePlus']"));
        onepluse.click();
        WebElement next = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));

        while (true) //untill loads last page
        {
            Thread.sleep(5000);
            next.click();
            Thread.sleep(5000);
            js.executeScript("window.scrollBy(0,2000)");
            Thread.sleep(5000);

            List<WebElement> mobile_list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            List<String> list1 = new ArrayList<String>();

            for (WebElement list : mobile_list)
            {
                list1.add(list.getText());
                System.out.println(list.getText());
            }

            System.out.println("######################");

            try //important try-catch for next button
            {
                next = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
            }
            catch (Exception e)
            {
                System.out.println("no more products");
                break;
            }
        }
    }
}
