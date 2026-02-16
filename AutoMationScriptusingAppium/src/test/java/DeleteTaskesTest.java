import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DeleteTaskesTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 5");
        options.setPlatformName("Android");

        options.setAppPackage("com.example.android.architecture.blueprints.main");
        options.setAppActivity("com.example.android.architecture.blueprints.todoapp.TodoActivity");
        options.setAutomationName("UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void deleteTask() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New Task"))).click();

        driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).sendKeys("BuyMilk");

        // 3️⃣ Enter Description
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[2]"))).sendKeys("From Market");
        //Tap Save
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"BuyMilk\")"))).click();

        // 5️⃣ اضغط Delete
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Delete task"))).click();

    }

}

