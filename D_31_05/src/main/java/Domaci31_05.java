import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Domaci31_05 {

        private WebDriver driver;

        @BeforeClass
        public void browserSetUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.telerik.com/support/demos/");
        }

        @Test
        public void desktopTest() throws InterruptedException {
            WebElement desktopButton = driver.findElement(By.cssSelector("a[href='#desktop']"));
            desktopButton.click();

            Thread.sleep(4000);
            boolean actualResult = desktopButton.getAttribute("class").contains("is-active");
            boolean expectedResult = true;
            Assert.assertEquals(actualResult, expectedResult);

        }

        @Test
        public void mobileTest() throws InterruptedException {
            WebElement mobileButton = driver.findElement(By.cssSelector("a[href='#mobile']"));
            mobileButton.click();
            Thread.sleep(4000);
            boolean actualResult = mobileButton.getAttribute("class").contains("is-active");
            boolean expectedResult = true;
            Assert.assertEquals(actualResult, expectedResult);

        }

        @AfterClass
        public void close() {
            driver.close();
        }

    }

