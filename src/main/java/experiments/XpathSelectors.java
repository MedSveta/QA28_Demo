package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsTextBox(){
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();
       // WebElement inputFullName = driver
                //.findElement(By.xpath(
                       // "//label[@id='userName-label']"));
        WebElement inputFullName = driver
                .findElement(By.xpath(
                        "//input[@id='userName']"));
        inputFullName.sendKeys("Monkey");
        WebElement inputEmail = driver
                .findElement(By
                        .xpath("//input[@placeholder" +
                                "='name@example.com']"));
        inputEmail.sendKeys("ert@rty.com");
        WebElement curAddress = driver.findElement(By
                .xpath("//*[text()='Current Address']"));
        System.out.println(curAddress.getText());
        WebElement inputCurAdd= driver.findElement(By
                .xpath(
                        "//*[text()=" +
                                "'Current Address']/../..//textarea"));
        inputCurAdd.sendKeys("Monkey street 3");
        WebElement inputPerAdd = driver.findElement(By
                .xpath("//div[@id='permanentAddress-wrapper']" +
                        "//textarea"));
        inputPerAdd.sendKeys("Monkey st 6");
        WebElement btnSubmit = driver.findElement(By
                .xpath("//button[text()='Submit']"));
        btnSubmit.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement output = driver.findElement(By
                .xpath("//div[@id='output']"));
        System.out.println(output.getText());

        //driver.quit();
    }

    private void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }
    private void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
