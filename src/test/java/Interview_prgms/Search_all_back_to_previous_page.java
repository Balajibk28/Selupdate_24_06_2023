package Interview_prgms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Search_all_back_to_previous_page
{
    public static void main(String[] arg) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");

        WebElement mobiles=driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_mobiles']"));
        mobiles.click();

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,2500)");

        WebElement onepluse= driver.findElement(By.xpath("//span[text()='OnePlus']"));
        onepluse.click();
        WebElement next=driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));

        while (true)
        {
             Thread.sleep(5000);
             next.click();
             Thread.sleep(5000);
             js.executeScript("window.scrollBy(0,2000)");
             Thread.sleep(5000);

             List<WebElement> mobile_list=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
             List<String> list1=new ArrayList<String>();

             for (WebElement list : mobile_list)
            {
                list1.add(list.getText());
                System.out.println(list.getText());
            }

            System.out.println("######################");

             try
             {
                 next=driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"));
             }
             catch (Exception e)
             {
                 System.out.println("no more products");
                 break;
             }
        }
        JavascriptExecutor js1=(JavascriptExecutor)driver;
        js1.executeScript("window.scrollBy(0,-1500)");

        Thread.sleep(8000);
        WebElement ele_3=driver.findElement(By.xpath("//a[@aria-label='Go to page 3']"));
        Thread.sleep(2000);
        ele_3.click();

        WebElement product=driver.findElement(By.xpath(" //span[text()='(Renewed) OnePlus Nord 5G Gray Onyx, 8GB RAM, 128GB Storage']"));
        js.executeScript("arguments[0].scrollIntoView(true)", product);
        product.click();
        System.out.println("Scrolled");

        Set<String> windows=driver.getWindowHandles();
        for (String handles:windows)
        {
            System.out.println(handles);
        }
        List<String> sw=new ArrayList<String>(windows);
        String first=sw.get(1);
        driver.switchTo().window(first);
        System.out.println("Switched");
        WebElement addcart=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addcart.click();
        System.out.println("Clicked");
    }
}
