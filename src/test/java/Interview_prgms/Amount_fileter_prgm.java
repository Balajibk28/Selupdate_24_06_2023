package Interview_prgms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amount_fileter_prgm
{
    public  static void main(String[] arg)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");

        WebElement mobiles=driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_3']"));
        mobiles.click(); //mobile selected

        WebElement samsung=driver.findElement(By.xpath("//span[text()='Samsung']"));
        samsung.click(); //brand selected

        List<WebElement> pricelist=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        //price list xpath
        for(int i=2;i< pricelist.size();i++)
        {
            WebElement price=pricelist.get(i);
            String pri=price.getText();
            int amount2=Integer.parseInt(pri.replaceAll("[^0-9]","").toString());

            int count=1;
            if(amount2>15000)
            {
                WebElement ex=driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']//parent::span"));
                System.out.println(ex.getText());
                System.out.println(amount2);
                count ++;
            }
            if(count>2)
                break;
        }
    }
}
