package Interview_prgms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Web_table_tough
{
    public static void main(String[] arg)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://cosmocode.io/automation-practice-webtable/");

        List<WebElement> row_count=driver.findElements(By.xpath("//table[@id='countries']//tr"));
        System.out.println(row_count.size());

        List<WebElement> col_count=driver.findElements(By.xpath("//table[@id='countries']//tr[2]/td"));
        System.out.println(col_count.size());

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1500)");

        for (int i=2;i<10;i++)
        {
            WebElement  details1=driver.findElement(By.xpath("//table[@id='countries']//tr["+i+"]/td//input[@class='hasVisited']"));
            details1.click();
            System.out.println("Clicked");
            for(int j=1;j<=5;j++)
            {

                WebElement  details=driver.findElement(By.xpath("//table[@id='countries']//tr["+i+"]/td["+j+"]"));
                System.out.println(details.getText());
            }
        }


    }
}
