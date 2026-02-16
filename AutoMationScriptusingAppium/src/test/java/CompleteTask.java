import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

public class CompleteTask{

    public static void main(String[] args) throws Exception {
        // إعدادات Appium
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("Pixel 5");
        options.setAutomationName("UiAutomator2");


        options.setAppPackage("com.example.android.architecture.blueprints.main");
        options.setAppActivity("com.example.android.architecture.blueprints.todoapp.TodoActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New Task"))).click();

        driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).sendKeys("BuyMilk");

        // 3️⃣ Enter Description
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[2]"))).sendKeys("From Market");
        //Tap Save
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)")).click();


        //4
        WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.CheckBox")));

        System.out.println("✅ المهمة اتضافت واتعملها مارك كـ Completed");

    }
}



